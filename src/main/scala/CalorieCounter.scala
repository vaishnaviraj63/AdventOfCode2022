package code.advent

import scala.io.Source


object CalorieCounter {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
//    day1()
    day2()
  }

  private def day1(): Unit = {
    val fileName = "/Users/vaishnavi.raj/Documents/Projects/AdventOfCode/src/main/resources/day-01"
    val list = scala.collection.mutable.ListBuffer[Int]()
    var sum = 0
    val source = Source.fromFile(fileName)
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

  private def day2(): Unit = {
    val fileName = "/Users/vaishnavi.raj/Documents/Projects/AdventOfCode/src/main/resources/day-02"
    val source = Source.fromFile(fileName)
    val input = source.getLines().toList
//    val input = List("A Y", "B X", "C Z")
    val resultScores = Map(
      "Z" -> 6,
      "Y" -> 3,
      "X" -> 0
    )
    val playScore = Map(
      "A" -> 1,
      "B" -> 2,
      "C" -> 3
    )
    val shapes = Map(
       "A" -> Map(
        "Z" -> "B",
        "Y" -> "A",
        "X" -> "C"
       ),
      "B" -> Map(
        "Z" -> "C",
        "Y" -> "B",
        "X" -> "A"
      ),
      "C" -> Map(
        "Z" -> "A",
        "Y" -> "C",
        "X" -> "B"
      )
    )

    val part1 = input.foldRight(0)((play: String, acc: Int) => {
      val x = play match {
        case "A X" =>
          playScore("A") + resultScores("X")
        case "A Y" =>
          playScore("B") + resultScores("Y")
        case "A Z" =>
          playScore("C") + resultScores("Z")
        case "B X" =>
          playScore("A") + resultScores("X")
        case "B Y" =>
          playScore("B") + resultScores("Y")
        case "B Z" =>
          playScore("C") + resultScores("Z")
        case "C X" =>
          playScore("A") + resultScores("X")
        case "C Y" =>
          playScore("B") + resultScores("Y")
        case "C Z" =>
          playScore("C") + resultScores("Z")
      }
      acc + x
    })

    println(s"Part 1 => $part1")

    val part2 = input.foldRight(0)((play: String, acc: Int) => {
      val x = play match {
        case "A X" =>
          playScore(shapes("A")("X")) + resultScores("X")
        case "A Y" =>
          playScore(shapes("A")("Y")) + resultScores("Y")
        case "A Z" =>
          playScore(shapes("A")("Z")) + resultScores("Z")
        case "B X" =>
          playScore(shapes("B")("X")) + resultScores("X")
        case "B Y" =>
          playScore(shapes("B")("Y")) + resultScores("Y")
        case "B Z" =>
          playScore(shapes("B")("Z")) + resultScores("Z")
        case "C X" =>
          playScore(shapes("C")("X")) + resultScores("X")
        case "C Y" =>
          playScore(shapes("C")("Y")) + resultScores("Y")
        case "C Z" =>
          playScore(shapes("C")("Z")) + resultScores("Z")
      }
      acc + x
    })

    println(s"Part 2 => $part2")
    source.close()
  }


}
