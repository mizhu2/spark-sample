#!/bin/bash
export PATH=$PATH:/home/user/spark-1.6.1-bin-hadoop2.6/bin
export HADOOP_CONF_DIR=/home/user/conf
export OUTPUT=outputyy
HADOOP_USER_NAME=hdfs spark-submit --master yarn --deploy-mode cluster --class WordCount \
    /projects/worldcount/target/scala-2.10/hello_2.10-1.0.jar \
    hdfs://172.16.1.11:8020/tmp/spark/input/wordcountinputfile1.txt \
    hdfs://172.16.1.11:8020/tmp/spark/output/$OUTPUT
