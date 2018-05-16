#!/bin/bash
#判断主机存活
#方法1，将错误的IP放到数组里面判断是否ping失败三次
set -e
set -x
IP_LIST='192.168.18.1 192.168.18.2'
#for IP in $IP_LIST; do
#    NUM=1
#    while [ $NUM -le 3 ]; do
#        if ping -c 1 $IP > /dev/null; then
#            echo "$IP ping is successful."
#            break
#        else
#            echo "$IP ping is failure $NUM"
#            FAIL_COUNT[$NUM]=$IP
#            let NUM++
##            NUM++
#        fi
#    done
#    if [ ${#FAIL_COUNT[*]} -eq 3 ]; then
#        echo "${FAIL_COUNT[1]} ping is failure!"
#        unset FAIL_COUNT[*]
#    fi
#done

#方法2:利用for循环将ping通就跳出循环继续，如果不跳出就会走到打印ping失败
ping_success_status() {
    if ping -c 1 $IP > /dev/null; then
        echo "$IP ping is successful"
        continue
    fi
}

for IP in $IP_LIST; do
    ping_success_status
    ping_success_status
    ping_success_status
    echo "$IP ping is failure"
done