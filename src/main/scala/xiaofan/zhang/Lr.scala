package xiaofan.zhang

import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.SparkSession

/**
  * Created by zhangxiaofan on 2019/3/27.
  */
object Lr {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("lr").master("local").
      config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse").getOrCreate()
    //import spark.implicits._
    val training = spark.createDataFrame(Seq(
      (1.0,Vectors.dense(0.0,1.1,0.1)),
      (0.0,Vectors.dense(2.0,1.0,-1.0)),
      (0.0,Vectors.dense(2.0,1.3,1.0)),
      (1.0,Vectors.dense(0.0,1.2,-0.5))
    )).toDF("label","featrues")
    training.show()
    spark.stop()
  }
}
