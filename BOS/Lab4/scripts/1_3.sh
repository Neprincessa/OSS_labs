#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
sorted_list=($(env | sort -df | cut -d'=' -f1))
echo "${sorted_list[*]}"
IFS="$SaveIFS"

