/**
  * Created by root on 6/30/16.
  */
import org.apache.spark._
import org.apache.spark.streaming._

/* Creating the new object and defining Main function */

object SparkStreamDemo1 {
  def main(args: Array[String]): Unit = {

    /* Create a local Streaming Context with two working thread and batch interval of 1 second and the master requires 2 cores to prevent from a starvation scenario. */

    val conf = new SparkConf().setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))


    /* Create a DStream that will connect to hostname:port, like localhost:9999 */

    val lines = ssc.socketTextStream(args(0), args(1).toInt)

    /* Split each line into words */

    val words = lines.flatMap(_.split(" "))

    /* Count each word in each batch */

    val pairs = words.map(word => (word, 1))

    val wordCounts = pairs.reduceByKey(_ + _)

    /* Print the first ten elements of each RDD generated in this DStream to the console */

    wordCounts.print()

    /* Start the computation */

    ssc.start()

    /* Wait for the computation to terminate */

    ssc.awaitTermination()
  }
}
