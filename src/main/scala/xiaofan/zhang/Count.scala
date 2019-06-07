package xiaofan.zhang

import org.apache.spark.sql.SparkSession

/**
  * Created by zhangxiaofan on 2019/6/5.
  */
object Count {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("lr").master("local").
      config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse").getOrCreate()
    val path = "D:\\GITRepo\\SparkMlTest\\src\\main\\resources\\a.txt"
    val unit = spark.sparkContext.textFile(path)
    val tuple = unit.map({line =>
      val arr = line.split(" ")
      val name =arr(1);
      val score =arr(2)
      (name,(score,1))
    })
    tuple.reduceByKey((a,b) => (a._1+b._1,a._2+b._2)).
      map(x => (x._1,(x._2._1,x._2._1.toInt/x._2._2))).
      foreach(x =>print(x))
  }

}
