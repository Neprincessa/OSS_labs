#!/bin/bash
echo 'find' $1 'in' $2 'file and show ' $3 'maximum amount of strings'  
grep -m $3 $1 $2 | sort | nl  
