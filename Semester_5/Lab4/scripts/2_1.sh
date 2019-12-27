#!/bin/bash
date +"%d-%m-%y %T" >> /tmp/run.log
echo "Hello world!"
cat /tmp/run.log | wc -l >&2
