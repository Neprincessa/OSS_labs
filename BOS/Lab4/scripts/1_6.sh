#!/bin/bash
hidden_files=$(find . -maxdepth 1  -name ".*" -type f| wc -l)
usual_files=$(find . -maxdepth 1 -type f | grep -v "\.\/\..*" | wc -l)
echo "Домашний каталог пользователя"
echo $HOME
echo "Содержит обычных файлов"
echo $usual_files
echo "Содержит скрытых файлов"
echo $hidden_files
