#!/bin/bash

repoUrl=$1
username=$2
passwd=$3
scriptName=$4

endPoint='service/rest/v1/script'

printf "Deleting Nexus Repository Manager 3 API Script ${scriptName}\n"

curl -v -X DELETE -u ${username}:${passwd} "${repoUrl}/${endPoint}/${scriptName}"

exit 0


