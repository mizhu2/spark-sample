export PATH=$PATH:/home/user/hadoop-2.6.4/bin
export OUTPUT=outputxx
hadoop fs -cat hdfs://172.16.1.11:8020/tmp/spark/output/$OUTPUT/part-*
