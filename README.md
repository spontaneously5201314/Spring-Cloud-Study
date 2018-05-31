#学习Spring Cloud  
主要包括Spring Boot/Spring Cloud Eureka/...



记录下常用的命令,供以后查询使用
1.远程调试
    -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=2345
    
2.优化的思路
    做任何事都最好有条有理。老手往往能够做到不慌不忙，循序渐进，而新手则往往东一下，西一下，不知所措。
    面对一个问题程序，最好采用自顶向下的策略。先整体看看该程序运行时各种统计事件的大概，再针对某些方向深入细节。而不要一下子扎进琐碎细节，会一叶障目的
    
3.安装java
  yun install -y wget 
  wget http://download.oracle.com/otn-pub/java/jdk/8u161-b12/2f38c3b165be4555a1fa6e98c45e0808/jdk-8u161-linux-x64.rpm
  rpm -ivh jdk-8u77-linux-i586.rpm

4.安装maven
  http://blog.csdn.net/clementad/article/details/46898013
