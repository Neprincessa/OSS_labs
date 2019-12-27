#!/bin/bash
bash $1 "1" " 2" "3"
bash $1 "foo" "bar" "foobar"  "foo bar"
bash $1 "foo" "--foo" "--help" "-I"
bash $1 "$RANDOM" "$RANDOM" "$RANDOM" "$RANDOM" "$RANDOM"
