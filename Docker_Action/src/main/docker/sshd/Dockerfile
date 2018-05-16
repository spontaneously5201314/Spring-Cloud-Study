#设置基础镜像
FROM ubuntu:14.04

#提供维护者的信息
MAINTAINER Spontaneously@yeah.net

#下面开始更新命令,并安装ssh服务
RUN apt-get update && apt-get install -y openssh-server && rm -rf /var/lib/apt/lists/*

#创建文件夹
RUN mkdir -p /var/run/sshd && mkdir -p /root/.ssh

#取消ram限制
RUN sed -ri 's/session  required    pam_loginuid.so/#session  required    pam_loginuid.so/g' /etc/pam.d/sshd

#复制配置文件到相应位置，并赋予脚本可执行权限
#ADD authorized_keys /root/.ssh/authorized_keys
ADD run.sh /run.sh
RUN chmod 755 /run.sh

#开放端口
EXPOSE 22

#设置自启动命令
CMD ["/run.sh"]

