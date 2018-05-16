#!/bin/bash
#测试下shift传递变量的作用
set -x
while [ -n "$*" ]
do
    echo $1 $2 $3 $4 $5 $6
    shift
done