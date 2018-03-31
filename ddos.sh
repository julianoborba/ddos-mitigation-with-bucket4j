#!/bin/sh
for i in `seq 1 1000`; do curl --connect-timeout 0 --max-time 60000 --keepalive-time 60000 http://localhost:8079/ddos/someservice/verylazy; done