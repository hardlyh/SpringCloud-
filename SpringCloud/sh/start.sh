#!/bin/sh

# jar name
APPLIBNAME=springcloud-eureka-server-0.0.1-SNAPSHOT.jar
ADAPTERDIR=`pwd`

if [ ! -d $ADAPTERDIR'/log' ]
then
	mkdir $ADAPTERDIR'/log'
fi


#Java system property
JAVA_OPTS=""
#JAVA_OPTS=${JAVA_OPTS}" -Xms512m -Xmx512m -Xmn256m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
JAVA_OPTS=${JAVA_OPTS}" -XX:+UseParNewGC -XX:+UseConcMarkSweepGC"
JAVA_OPTS=${JAVA_OPTS}" -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${ADAPTERDIR}/log/java_heapdump.hprof"
JAVA_OPTS=${JAVA_OPTS}" -Xloggc:${ADAPTERDIR}/log/app_gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"
JAVA_OPTS=${JAVA_OPTS}" -jar ${APPLIBNAME}"
# 配置文件单独存放
# JAVA_OPTS=${JAVA_OPTS}" --spring.config.additional-location=$ADAPTERDIR/conf/"
# 区分环境可能用到传递固定的参数
# JAVA_OPTS=${JAVA_OPTS}" --ENV.RUNTYPE=${envRunType}"
# JAVA_OPTS=${JAVA_OPTS}" --ENV.CLUSTER=${envCluster}"

X=0
COUNT=`ps -ef | grep java | grep ${APPLIBNAME} |grep -v grep | wc | awk '{print $1 }'`
if [ "$COUNT" -ge 1 ]
	then
	  echo 'There is already '$COUNT $ADAPTERDIR 'adapter running.Trying Stop it'
	  cd $ADAPTERDIR
	  pid=`ps -ef | grep java | grep ${APPLIBNAME} |awk '{print $2}'`
	  echo $pid
	  kill -9 $pid
          if [ "$?" -eq 0 ]; then
              echo "kill success"
          else
              echo "kill failed"
          fi 
	else
	  echo 'Trying to start' $ADAPTERDIR 'app.'
fi

java  $JAVA_OPTS 1>/dev/null 2>stderr &
#X=0
#while [ "$X" -le "$COUNT" ]
#do
#  let X=X+1
#  java  $JAVA_OPTS 1>/dev/null 2>stderr &
#done
