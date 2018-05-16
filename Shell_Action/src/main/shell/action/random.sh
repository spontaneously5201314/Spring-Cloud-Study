#!/bin/bash
#获取随机8位字符串的三种方法
echo $RANDOM | md5sum | cut -c 1-8
openssl rand -base64 4
cat /proc/sys/kernel/random/uuid | cut -c 1-8

#获取随机8位数字的三种方法
echo $RANDOM | cksum | cut -c 1-8
openssl rand -base64 4 | cksum | cut -c 1-8
date +%N | c ut -c 1-8