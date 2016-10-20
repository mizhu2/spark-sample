
import org.apache.spark.{SparkContext, SparkConf}

object ContainsWord
{
  def main(args:Array[String])
  {
    val inputFile = args(0)
    val name = args(1)
    val conf = new SparkConf().setAppName("ContainsWord")
    val sc = new SparkContext(conf)
    
    /* This is the input file which we are passing to find the word “hello”. Here it is case sencitive. */

    val file = sc.textFile(inputFile)
    val filter = file.filter(_.contains(name))

    /* count() will count the number of occurrences of a word and print the count */
    val count=filter.count()
    println(count)

  }
}
