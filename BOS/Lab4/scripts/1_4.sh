#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
echo "Good morning!"
current_date=$(date +%H:%M)
current_month=($(cal -1))
current_list=($(cat $HOME/TODO))
echo "Current time: " $current_date
echo "Current month:" 
echo "${current_month[*]}"
echo "Current list:" 
echo "${current_list[*]}"
IFS="$SaveIFS"
