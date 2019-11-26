#!/bin/bash
SaveIFS ="$IFS"
IFS=$'\n'
date=$(date +%D)
time=$(date +%H:%M)
users=($(sed 's/:.*//' /etc/passwd))
server_time=$(uptime -p)
echo "Дата:" $date
echo "Время: " $time
echo "Зарегистрированные пользователи:"
echo "${users[*]}"
echo "Время работы системы: " $server_time
IFS="$SaveIFS"
