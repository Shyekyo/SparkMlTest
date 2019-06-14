package xiaofan.zhang

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, LongType, StringType, StructField, StructType}

/**
  * Created by zhangxiaofan on 2019/6/13.
  */
object Tsql {
  var path ="D:\\GITRepo\\SparkMlTest\\src\\main\\resources\\a.txt"
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().
      appName("sql").master("local")
      .config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse")
      .getOrCreate()
    val schema_ad = StructType(
      StructField("id", IntegerType, true)::
        StructField("name", StringType, false)::
        StructField("score", LongType, false)::
        Nil
    )
  }
}
