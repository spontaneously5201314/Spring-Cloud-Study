#学习Spring Cloud  
主要包括Spring Boot/Spring Cloud Eureka/...

```
   SpringCloud资料的网站:
   http://www.itmuch.com
```


记录下常用的命令,供以后查询使用
1.远程调试
  > -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=2345
    
2.优化的思路
  > 做任何事都最好有条有理。老手往往能够做到不慌不忙，循序渐进，而新手则往往东一下，西一下，不知所措。
    面对一个问题程序，最好采用自顶向下的策略。先整体看看该程序运行时各种统计事件的大概，再针对某些方向深入细节。而不要一下子扎进琐碎细节，会一叶障目的
    
3.安装java
  > yun install -y wget 
  wget http://download.oracle.com/otn-pub/java/jdk/8u161-b12/2f38c3b165be4555a1fa6e98c45e0808/jdk-8u161-linux-x64.rpm
  rpm -ivh jdk-8u77-linux-i586.rpm

4.安装maven
  > http://blog.csdn.net/clementad/article/details/46898013
  
5.maven->gradle
  > gradle init --type pom
  
6.Spring Cloud中，Feign和Ribbon在整合了Hystrix后，可能会出现首次调用失败的问题，要如何解决该问题呢？
  > 造成该问题的原因  
  Hystrix默认的超时时间是1秒，如果超过这个时间尚未响应，将会进入fallback代码。而首次请求往往会比较慢（因为Spring的懒加载机制，要实例化一些类），这个响应时间可能就大于1秒了。知道原因后，我们来总结一下解决放你。解决方案有三种，以feign为例。
  方法一  
  hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 5000  
  该配置是让Hystrix的超时时间改为5秒  
  方法二  
  hystrix.command.default.execution.timeout.enabled: false  
  该配置，用于禁用Hystrix的超时时间  
  方法三  
  feign.hystrix.enabled: false  
  该配置，用于索性禁用feign的hystrix。该做法除非一些特殊场景，不推荐使用。 

7.在使用hystrix的时候,可以访问/hystrix.stream,但是在使用feign的时候,访问这个地址就会报错,提示不存在