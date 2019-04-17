package xiaofan.zhang

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.sql.{Row, SparkSession}

/**
  * Created by zhangxiaofan on 2019/3/27.
  */
object Lr {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.WARN)
    val spark = SparkSession.builder().appName("lr").master("local").
      config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse").getOrCreate()
    //import spark.implicits._
//    val training = spark.createDataFrame(Seq(
//      (1.0,Vectors.dense(0.0,1.1,0.1)),
//      (0.0,Vectors.dense(2.0,1.0,-1.0)),
//      (0.0,Vectors.dense(2.0,1.3,1.0)),
//      (1.0,Vectors.dense(0.0,1.2,-0.5))
//    )).toDF("label","features")
//    training.show()
//    val lr = new LogisticRegression()
//    print("model1 : " + lr.explainParams())
//    lr.setMaxIter(10).setRegParam(0.01)
//    val model1 = lr.fit(training)
//    print("model 1 model1 : "+model1.parent.explainParams())
//    val param1 = ParamMap(lr.maxIter -> 20).put(lr.maxIter,30).
//      put(lr.regParam -> 0.1,lr.threshold -> 0.55)
//    val param2 = ParamMap(lr.probabilityCol -> "myProbability")
//    val paramMapCombined = param1 ++ param2
//    val model2 = lr.fit(training,paramMapCombined)
//
//    val test = spark.createDataFrame(Seq(
//      (1.0,Vectors.dense(-1.0,1.5,1.3)),
//      (0.0,Vectors.dense(3.0,2.0,-0.1)),
//      (1.0,Vectors.dense(0.0,2.2,-1.5))
//    )).toDF("label","features")
//    test.show()
//    model1.transform(test).select("features","label","probability","prediction")
//      .collect().foreach{
//      case Row(features1,label,prob,prediction)
//        => println(s"($features1,$label) -> prob=$prob , prediction=$prediction")
//    }
//
//    model2.transform(test).select("features","label","myProbability","prediction")
//      .collect().foreach{
//      case Row(features2,label,prob,prediction)
//      => println((features2,label) + s" -> prob=$prob , prediction=$prediction")
//    }
//    println(" model 2 coefficients : "+model2.coefficients +" intercept : "+model2.intercept)
//    println(" model 1 coefficients : "+model1.coefficients +" intercept : "+model1.intercept)
    val line = spark.sparkContext.parallelize(Seq(("1 sdf:0"),("0 wer:1")))
    val c = line.map(x => {
      val sb = new StringBuilder()
      sb.clear()
      val arr = x.split(" ")
      val label=arr(0)
      val one=arr(1)
      val two = one.split(":")
      val a = two(0)
      val b = two(1)
      sb.append(label).append(" ").append(a).append(":").append(a).append(":").append(b)
    })
    c.foreach(x => println(x))

    spark.stop()
  }
}
