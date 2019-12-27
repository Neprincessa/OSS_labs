#!/bin/bash
SaveIFS="$IFS"
IFS=$'\n'
directories=($(ls -l . | grep ^d | tr -s ' '))
echo "Каталоги:"
echo "${directories[*]}"
files=($(ls -l . | grep "^-" | tr -s ' '))
echo "Файлы:"
echo "${files[*]}"
symbol_links=($(ls -l . | grep ^l | tr -s ' '))
echo "Символьные ссылки:"
echo "${symbol_links[*]}"
symbol_devices=($(ls -l . | grep ^c | tr -s ' '))
echo "Символьные устройства:"
echo "${symbol_devices[*]}"
block_devices=($(ls -l . | grep ^b | tr -s ' '))
echo "Блочные устройства:"
echo "${block_devices[*]}"
IFS="$SaveIFS"

