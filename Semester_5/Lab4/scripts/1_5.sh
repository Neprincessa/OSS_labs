#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
current_files=($(find /usr -depth -size +20M))
echo "Current files:"
echo "${current_files[*]}"
IFS="$SaveIFS"
