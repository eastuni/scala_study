val fruit = List("apple","oranges","pears")
val nums = List(1,2,3,4)
val diag3 = List(List(0,1,1),List(0,1,0),List(0,0,1))
val empty = List()
//cons
val fruit2 = "apple" :: ("oranges" :: ("pears" :: Nil))

val nums2 = 1 :: 2 :: 3 :: 4 :: Nil
//equal
Nil .:: (4) .:: (3) .:: (2) .:: (1)

//head, tail , isEmpty

fruit.head
fruit.tail.head
diag3.head
empty.isEmpty

//list patterns
val xs = 3 :: 4 :: 8 :: 1:: 3:: 7 ::Nil
val xx = 1 :: 2 :: Nil
1 :: Nil
List(1)

xx ::: xs


//x :: y :: List(xs,ys) :: zs. L >= 3
val test = 1 :: 2 :: List(4,5) :: 6  :: Nil
test.length

//sorting lists

// insertions sorts

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

def insert(x:Int, xs:List[Int]):List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if( x <= y) x :: xs else y :: insert(x,ys)
}

isort(xs)

