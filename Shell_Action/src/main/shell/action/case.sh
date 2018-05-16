#!/bin/bash
#测试case判断
set -x
case $1 in
     1)
        echo "1"
        ;;
     2)
        echo "2"
        ;;
     *)
        echo "*"
        ;;
esac