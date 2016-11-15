
val coll1 = List(1,2,3,4,5)

val coll2 = 1 until 5
val coll3 = 1 to 5
val coll4 = 1 to 10 by 2

def isPrime(n: Int) = (2 until n) forall ( n % _ != 0)
val n = 7

(1 until n) flatMap (i =>
  (1 until i) map (j => (i,j))) filter
  (pair => isPrime(pair._1 + pair._2))


case class person(name: String, age: Int)

//for (p <- person if p.age > 20) yield p.name

for {
   i <- 1 until n
   j <- 1 until i
  if isPrime(i + j)
} yield (i,j)


def scalaProduct(xs: List[Double], ys: List[Double]) : Double =
  (for ((x,y) <- xs zip ys) yield x * y).sum

val fruit = Set("apple","banana","pear")
val s = (1 to 6).toSet

s map (_ / 2)

s contains 5

//N-Queens

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(kk: Int): Set[List[Int]] =
    if( kk == 0 ) Set(List())
    else
    for {
      queens <- placeQueens( kk - 1)
      col <- 0 until n
      if isSafe(col, queens)
    }
      yield col :: queens
  placeQueens(n)
}

def isSafe(col:Int, queens: List[Int]): Boolean ={
  val row = queens.length
  val queensWithRow = (row - 1 to 0 by -1) zip queens
  queensWithRow forall {
    case(r, c) => col != c && math.abs(col - c) != row - r
  }
}
def show (queens: List[Int]) = {
  val lines =
    for ( col <- queens.reverse)
      yield Vector.fill(
        queens.length)("* ").updated(col,"X ").mkString
  "\n" + (lines mkString "\n")
}
  queens(4) map show



