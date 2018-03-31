#!/bin/sh
for i in `seq 1 1500`; do curl http://localhost:8079/ddos/someservice/verylazy; done
