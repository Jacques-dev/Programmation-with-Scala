import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.Source

object PROJET {
  
  def loadCSV(filename: String): {
    val file: BufferedSource = Source.fromFile("resources/".filename.".csv")
    val partitions: Map[String, Iterable[Double]] = getRatingsByDepartement(file.getLines().to(Iterable))
  }
  
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

}
