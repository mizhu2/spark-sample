/**
  * Created by root on 6/30/16.
  */
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}


/* Creating the new object and defining Main function */

object DataFrameOps
{
  def main(args:Array[String]):Unit= {

    /* Adding the Mysql connector jar to communicate spark with mysql database */
    val conf = new

      /* Setting the Appname, Master and Memory with respective values */

        SparkConf().setAppName("DataFrameOps")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    /* Passing the input file on which we want to do all operations */

    val df = sqlContext.jsonFile(args(0))

    /* Displays the content of the DataFrame (file data) */

    df.show()

    /* Print the schema in a tree format */

    df.printSchema()

    /* Select only the "name" column from the input file */

    df.select("name").show()

    /* Select everybody, but increment the age by 1 */

    df.select(df.col("name"), df.col("age").plus(1)).show()

    /* Select people older than 21 */

    df.filter(df.col("age").gt(21)).show()

    /* Count people by age */

    df.groupBy("age").count().show()


  }
}
