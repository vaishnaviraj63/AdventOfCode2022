package code.advent

import scala.io.Source


object Day1 {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
    day1()
  }

  private def day1(): Unit = {
    val list = scala.collection.mutable.ListBuffer[Int]()
    var sum = 0
    val source = Source.fromResource("day-01")
    source.getLines().toList.collect {
      a => if(a.isBlank) {
        list.addOne(sum)
        sum = 0
      } else {
        sum = sum + a.toInt
      }
    }
    val sortedList = list.sorted.reverse
    println(s"Part 1 - Elves with most amount of calories ${sortedList.head}")
    println(s"Part 2 - Sum of the calories being carried by the top three eleves ${sortedList.take(3).sum}")

    source.close()
  }
}
