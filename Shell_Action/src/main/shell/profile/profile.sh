#!/bin/bash
#获取机器的CPU，内存，硬盘和网卡流量的利用率的脚本
#set -x
DATE=$(date +%F" "%H:%M)
#只支持CentOS6
IP=$(ifconfig eth0 | awk -F ' [ :]+' '/inet addr/{print $4}')
MAIL="hongfei@cmcm.com"
if ! which vmstat &> /dev/null; then
    echo "vmstat command no found, please install procps package"
    exit 1
fi

#获取CPU统计信息
US=$(vmstat | awk 'NR==3{print $13}')
SY=$(vmstat | awk 'NR==3{print $14}')
IDLE=$(vmstat | awk 'NR==3{print $15}')
WAIT=$(vmstat | awk 'NR==3{print $16}')
USE=$(($US+$SY))

#获取内存利用率
MUSED=$(free -m | awk 'NR==3{print $3}')
MFREE=$(free -m | awk 'NR==3{print $4}')

#获取硬盘
df -h | awk '/^\/dev/{print $0}'

echo "
    Date: $DATE
    Host: $IP
    CPU USED: $USE%
    MEMORY USED: ${MUSED}M"
#" | mail -s "CPU Monitor" $MAIL
