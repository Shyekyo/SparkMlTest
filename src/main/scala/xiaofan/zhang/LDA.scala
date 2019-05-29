package xiaofan.zhang

import breeze.linalg.{DenseMatrix, DenseVector}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.api.java.UDF1

/**
  * Created by zhangxiaofan on 2019/3/28.
  */
object LDA {

  def getSeqStr(s:String)={
   (s: String) => s.split(":").map(_.split("/")).filter(_.size == 2)
      .filter(s => !Array("wp", "u").contains(s(1)))
  }

 /* def getSeqStr(s:String) = {
      val filter = s.split(":").map(_.split("/")).filter(_.size == 2)
        .filter(s => !Array("wp", "u").contains(s(1)))
      filter
   }*/

  def main(args: Array[String]): Unit = {
    val string = "</wp:p/ws:>/wp:双色球/n:红/a:球/n:刀山/n:算法/n"
    println(DenseMatrix.zeros[Int](5,5))
    println(DenseVector.ones[Int](5))
    println(DenseMatrix((1.0,2.0),(3.0,4.0)))
    println(DenseVector.tabulate(3){i => 2*i})
    val rand = DenseMatrix.rand[Double](2,3)
    println(rand)
    println(rand(0,1))

    val spark = SparkSession.builder().appName("lr").master("local").
      config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse").getOrCreate()
    val movies = spark.sparkContext.parallelize(Array[String]("wo shi","gu du"))
    val collect = movies.map({ line =>
      val words = line.split(" ")
      (words(0), words(1))
    }).collect()
    val toMap = collect.toMap
    print(toMap)

  }

}
