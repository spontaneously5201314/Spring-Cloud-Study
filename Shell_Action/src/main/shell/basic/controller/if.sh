#!/bin/bash
set -evx
read -p "please input your name" NAME
printf '%s\n' ${NAME}
if [ ${NAME} = root ]
then
    echo "hello ${NAME}, welcome"
elif [ ${NAME} = Spontaneously ]
then
    echo "hello ${NAME}"
else
    echo "get out"
fi