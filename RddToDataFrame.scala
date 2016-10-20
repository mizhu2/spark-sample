import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/* sample category, name, age will be DataFrame column names. */
case class People(name:String,age:Int)
/* Creating the new object and defining Main function */

object RddToDataFrame
{
  def main(args:Array[String]): Unit =
  {

    /* Setting application name and, Master as Local. Setting memory as well */

    val conf = new SparkConf().setAppName("SparkSQL-TEST")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    /* The introduction of implicit conversion. This sample with class RDD, it can be directly converted in to DataFrame and the sample type parameter name is the column name. */

    import sqlContext.implicits._

    /* Here people is a DataFrame and path of the text file*/

    val people = sc.textFile(args(0)).map(_.split(" ")).map(p => People(p(0), p(1).toInt)).toDF

    /* Register as a temporary table */

    people.registerTempTable("people")

    /* Here selecting the data from the table People */

    val people_dataFrame = sqlContext.sql("select * from people")
    
    people_dataFrame.show();
  }
}

