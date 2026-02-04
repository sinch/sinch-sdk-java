#!/bin/sh

(cd snippets && ./compile.sh)  || exit 1
(cd webhooks && ./compile.sh)  || exit 1
