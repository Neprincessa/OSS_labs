#!/bin/bash
find ~ -maxdepth 1 -type f -name "*\.txt"
find ~ -type f -name "*\.txt" | xargs du -c | awk '{i+=$1} END {print i}'
