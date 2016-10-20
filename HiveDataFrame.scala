/**
  * Created by root on 6/30/16.
  */
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/* Creating the new object and defining Main function */

object HiveDataFrame
{
  def main(args:Array[String]): Unit =
  {

    /* Settings for SparkSQL,Made from a sc */

    val conf = new SparkConf().setAppName("HiveDataFrame")
    val sc = new SparkContext(conf)

    /* Defining Hive context to access the Hive data from Spark */

    val hiveContext=new HiveContext(sc);

    /* Accessing the Hive tables. Finding list of Tables in default database and displaying (show()) */

    hiveContext.sql("show tables").show()


    /* Selecting the data from the table Student which is in Hive */

    //hiveContext.sql("select * from student").first()

  }
}

