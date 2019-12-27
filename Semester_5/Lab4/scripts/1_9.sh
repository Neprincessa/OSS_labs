#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
current_process=($(ps -eo cmd --sort=-%mem | head -5))
echo "Количество процессов:"
echo "${current_process[*]}"
