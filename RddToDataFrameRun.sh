HADOOP_USER_NAME=devnet spark-submit --master yarn --deploy-mode cluster --class RddToDataFrame /projects/worldcount/target/scala-2.10/hello_2.10-1.0.jar hdfs://172.16.1.11:8020/tmp/spark/input/people2.txt