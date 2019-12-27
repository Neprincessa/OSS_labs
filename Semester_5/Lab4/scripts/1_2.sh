#!/bin/bash
DIR=$HOME
result=$(ls $DIR | grep -E -c  ".*\.txt$")
echo $result
