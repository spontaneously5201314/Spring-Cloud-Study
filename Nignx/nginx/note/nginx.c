void
ngx_process_events_and_timers(ngx_cycle_t *cycle)
{
。。。 。。。
    //ngx_use_accept_mutex表示是否需要通过对accept加锁来解决惊群问题。当nginx worker进程数>1时且配置文件中打开accept_mutex时，这个标志置为1
    if (ngx_use_accept_mutex) {
    		//ngx_accept_disabled表示此时满负荷，没必要再处理新连接了，我们在nginx.conf曾经配置了每一个nginx worker进程能够处理的最大连接数，当达到最大数的7/8时，ngx_accept_disabled为正，说明本nginx worker进程非常繁忙，将不再去处理新连接，这也是个简单的负载均衡
        if (ngx_accept_disabled > 0) {
            ngx_accept_disabled--;

        } else {
        		//获得accept锁，多个worker仅有一个可以得到这把锁。获得锁不是阻塞过程，都是立刻返回，获取成功的话ngx_accept_mutex_held被置为1。拿到锁，意味着监听句柄被放到本进程的epoll中了，如果没有拿到锁，则监听句柄会被从epoll中取出。
            if (ngx_trylock_accept_mutex(cycle) == NGX_ERROR) {
                return;
            }

						//拿到锁的话，置flag为NGX_POST_EVENTS，这意味着ngx_process_events函数中，任何事件都将延后处理，会把accept事件都放到ngx_posted_accept_events链表中，epollin|epollout事件都放到ngx_posted_events链表中
            if (ngx_accept_mutex_held) {
                flags |= NGX_POST_EVENTS;

            } else {
            		//拿不到锁，也就不会处理监听的句柄，这个timer实际是传给epoll_wait的超时时间，修改为最大ngx_accept_mutex_delay意味着epoll_wait更短的超时返回，以免新连接长时间没有得到处理
                if (timer == NGX_TIMER_INFINITE
                    || timer > ngx_accept_mutex_delay)
                {
                    timer = ngx_accept_mutex_delay;
                }
            }
        }
    }
		//linux下，调用ngx_epoll_process_events函数开始处理
    (void) ngx_process_events(cycle, timer, flags);
		//如果ngx_posted_accept_events链表有数据，就开始accept建立新连接
    if (ngx_posted_accept_events) {
        ngx_event_process_posted(cycle, &ngx_posted_accept_events);
    }

		//释放锁后再处理下面的EPOLLIN EPOLLOUT请求
    if (ngx_accept_mutex_held) {
        ngx_shmtx_unlock(&ngx_accept_mutex);
    }

    if (delta) {
        ngx_event_expire_timers();
    }

    ngx_log_debug1(NGX_LOG_DEBUG_EVENT, cycle->log, 0,
                   "posted events %p", ngx_posted_events);
		//然后再处理正常的数据读写请求。因为这些请求耗时久，所以在ngx_process_events里NGX_POST_EVENTS标志将事件都放入ngx_posted_events链表中，延迟到锁释放了再处理。
    if (ngx_posted_events) {
        if (ngx_threaded) {
            ngx_wakeup_worker_thread(cycle);

        } else {
            ngx_event_process_posted(cycle, &ngx_posted_events);
        }
    }
｝