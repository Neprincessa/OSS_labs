#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
list=($(du $HOME -s * | sort -nr | cut -f2))
echo "Файлы и каталоги упорядоченные по размеру:"
echo "${list[*]}"
IFS="$SaveIFS"
