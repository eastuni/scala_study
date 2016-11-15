package recfun

import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

    if (r ==0 || c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
    def calCh(chars: List[Char], numOfBal: Int): Boolean = {
      if (chars.isEmpty) {
        numOfBal == 0
      } else {
        val ch = chars.head
        val n =
          if (ch == '(') numOfBal + 1
          else if (ch == ')') numOfBal - 1
          else numOfBal
        if (n >= 0) calCh(chars.tail, n)
        else false
      }
    }

    calCh(chars, 0)
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
    def f(total_coll: List[(Int, Int)], count: Int): Int = {
      if (total_coll.isEmpty) {
        count
      } else {
        val b = ListBuffer[(Int, Int)]()
        var newCount = count
        for ((maxCoin, total) <- total_coll) {
          if (total < money) {
            for (c <- coins) {
              if (c >= maxCoin) {
                b.append((c, total + c))
              }
            }
          } else if (total == money) {
            newCount += 1
          }
        }

        f(b.toList, newCount)
      }
    }

    val b = coins.map { c => (c, c) }
    f(b, 0)

  }
  }
