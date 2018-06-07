#!/usr/bin/env bash
NGINXS=(10.46.100.146 10.46.100.221 10.46.100.203 10.46.100.152 10.46.100.216 10.46.100.97 10.46.100.144 10.46.100.71 10.46.100.214 10.46.100.237);
CLEAR_SERVER=10.46.100.245:8082
for ng_ip in ${NGINXS[@]}
do
ssh -t -t -p 22 root@$ng_ip 'killall -9 nginx;sleep 1'
ssh -t -t -p 22 root@$ng_ip 'killall -9 nginx;sleep 1'
echo "[SHUTDOWN nginx]ssh -t -t -p 22 root@$ng_ip end.. " >> /data/scripts/test.log
done
FLUSH_URL="http://$CLEAR_SERVER/arrow/flushall?key=A4C7312VCM08"
curl -w %{time_total} $FLUSH_URL
curl -w %{time_total} $FLUSH_URL
curl -w %{time_total} $FLUSH_URL
echo "CLEAR DATA[$FLUSH_URL] SUCCESS.." >> /data/scripts/test.log
for nt_ip in ${NGINXS[@]}
do
ssh -tt root@$nt_ip << remotessh
killall -9 java
killall -9 java
/data/netty/netty/cmplay-game-gw-1.0-RELEASE-9007/bin/restart.sh $nt_ip 9007|sed -e /9007/q
sleep 2
echo "$nt_ip NETTY START SUCCESS!"
exit
exit
remotessh
sleep 2
echo "[RESTART netty]ssh -t -p 22 root@$nt_ip restartnetty.sh ..." >> /data/scripts/test.log
done
for ng_ip in ${NGINXS[@]}
do
ssh -t -t -p 22 root@$ng_ip '/usr/local/nginx_lua/sbin/nginx -c /etc/nginx/nginx.conf;sleep 1'
echo "[OPEN nginx]ssh -t -p 22 root@$ng_ip nginx ..." >> /data/scripts/test.log
done
sleep 1
echo "SUCCESS!" >> /data/scripts/test.log