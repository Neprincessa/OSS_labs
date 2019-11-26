#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
directories=($(ls -l $1 | grep ^d | tr -s ' '))
echo "Каталоги:"
echo "${directories[*]}"
files=($(ls -l $1 | grep "^-" | tr -s ' '))
echo "Файлы:"
echo "${files[*]}"
symbol_links=($(ls -l $1 | grep ^l | tr -s ' '))
echo "Символьные ссылки:"
echo "${symbol_links[*]}"
symbol_devices=($(ls -l $1 | grep ^c | tr -s ' '))
echo "Символьные устройства:"
echo "${symbol_devices[*]}"
block_devices=($(ls -l $1 | grep ^b | tr -s ' '))
echo "Блочные устройства:"
echo "${block_devices[*]}"
IFS="$SaveIFS"
