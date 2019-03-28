package xiaofan.zhang

import java.io.File

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.{Pipeline, PipelineModel}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{HashingTF, Tokenizer}
import org.apache.spark.sql.{Row, SparkSession}

/**
  * Created by zhangxiaofan on 2019/3/28.
  */
object Ppline {
  Logger.getLogger("org").setLevel(Level.WARN)
  def main(args: Array[String]) = {
    val spark = SparkSession.builder().master("local").appName("pipeline")
      .config("spark.sql.warehouse.dir", "D:/GITRepo/SparkMlTest/spark-warehouse")
      .getOrCreate()
    val training = spark.createDataFrame(Seq(
      (0L, "a b c d e spark", 1.0),
      (1L, "b d", 0.0),
      (2L, "spark f g h", 1.0),
      (3L, "hadoop mapreduce", 0.0)
    )).toDF("id", "text", "label")
    training.show()
    val tokenizer = new Tokenizer()
      .setInputCol("text")
      .setOutputCol("words")
    val hashingTf = new HashingTF()
      .setNumFeatures(1000)
      .setInputCol(tokenizer.getOutputCol)
      .setOutputCol("features")

    val lr = new LogisticRegression()
      .setMaxIter(30)
      .setRegParam(0.001)

    val pipeline = new Pipeline()
      .setStages(Array(tokenizer,hashingTf,lr))
    val model = pipeline.fit(training)
    //保存模型
    val lr_model="file:/tmp/spark-pipeline-lr-model"
    val lr_path = new File(lr_model)
    lr_path.deleteOnExit()
    model.write.overwrite().save(lr_model)
    //保存pipeling
    val pl_model_path = "file:/tmp/spark-pipeline-model"
    val pl_path = new File(pl_model_path)
    pl_path.deleteOnExit()
    pipeline.write.overwrite().save(pl_model_path)
    //加载plmodel
    val pl_model = PipelineModel.load(pl_model_path)

    val test = spark.createDataFrame(Seq(
      (4L, "spark i j k"),
      (5L, "l m n"),
      (6L, "spark hadoop spark"),
      (7L, "apache hadoop")
    )).toDF("id", "text")

    pl_model.transform(test)
      .select("id","text","probability","prediction")
      .collect().foreach({
      case Row(id, text, prob, prediction) =>
        println(s"($id,$text) --> prob=$prob,prediction=$prediction")}
    )

    spark.stop()
  }
}
