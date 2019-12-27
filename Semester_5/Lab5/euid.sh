#!/bin/bash

ps axo euid,ruid,comm | tail -n +2 | while read line
do
	row=($line)
	if [ ${row[0]} != ${row[1]} ]
	then
		echo ${row[2]}
	fi
done
