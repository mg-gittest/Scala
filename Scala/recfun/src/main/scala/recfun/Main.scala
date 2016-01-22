package recfun
import common._

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
    if (r < 0 || c < 0 || c > r) {
      0
    } else {
       if (r == 0 || c == 0 || r == c ) {
         1
       } else {
         pascal(c-1, r-1) + pascal(c, r-1)
       }
    }
	}                      

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def balanceCount(count: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        count == 0
      } else {
        if (chars.head == '(') {
          balanceCount(count + 1, chars.tail)
        } else {
          if (chars.head == ')') {
            count > 0 && balanceCount(count - 1, chars.tail)
          }
          else {
            balanceCount(count, chars.tail)
          }
        }
      }
    }
    
    balanceCount(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 ) {
      // smallest available coin over stepped the required target from previous call
      0        
    } else if (coins.length < 1) {
      // we have no available coins to make the change
      0 
    } else if (money == 0 ) {
      1 // we have exactly matched coins with money required
    } else {
      val coinsSortedDesc = coins.sortWith(_ > _)
      val maxCoin = coinsSortedDesc.head
      (  countChange(money, coinsSortedDesc.tail )     // without using any of largest coin 
       + countChange(money - maxCoin, coinsSortedDesc) // at least one largest coin
      )
    }
  }
}
