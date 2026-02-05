#!/bin/sh

SDK_VERSION=$(cd .. && mvn -q  -Dexec.executable=echo  -Dexec.args='${project.version}'  --non-recursive  exec:exec)

export SDK_VERSION="${SDK_VERSION}"

(cd snippets && ./compile.sh)  || exit 1
(cd webhooks && ./compile.sh)  || exit 1
(cd getting-started && ./compile.sh)  || exit 1
