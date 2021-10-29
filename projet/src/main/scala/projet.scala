import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.Source



object PROJET {
  def loadData(filename: String): DataFrame = {
    val df = spark.read.csv("resources/"+filename+".csv")
    df.printSchema()
  }

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    
    val airports = loadData("airports")
    val countries = loadData("countries")
    val runways = loadData("runways")
  }
}