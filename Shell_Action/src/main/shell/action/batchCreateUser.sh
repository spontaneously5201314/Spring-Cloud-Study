#!/bin/bash
#批量创建用户
for USER in user{1..5}; do
    if ! id $USER &>/dev/null; then
        PASS=$(echo $RAMDOM | md5sum | cut -c 1-8)
        useradd $USER
        echo $PASS | passwd --stdin $USER &>/dev/null
        echo -e "$USER\t$PASS" >> $USER_FILE
        echo "$USER user create successful."
    else
        echo "$USER is already exists!"
    fi
done