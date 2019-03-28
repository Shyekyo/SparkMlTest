package xiaofan.zhang

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
  }

}
