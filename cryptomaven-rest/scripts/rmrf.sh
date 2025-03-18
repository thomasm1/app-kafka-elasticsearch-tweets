#!/bin/bash
TRASH_DIR="$HOME/.trash"
#create if not exist dir
[ ! -d "$TRASH_DIR" ] && mkdir -p "$TRASH_DIR"

mv "$@" "$TRASH_DIR"
echo "MOVED TO TRASH: $@"

