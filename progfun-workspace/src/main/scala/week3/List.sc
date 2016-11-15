import week3._

println("hello")

def singleton[T](elem:T) = new Cons[T](elem, new Nil[T])

singleton[Int](1)
singleton(1)

def nth[T](n: Int, xs: List[T]):T =
  if ( xs.isEmpty) throw new ArrayIndexOutOfBoundsException
  else if (n == 0) xs.head
  else nth(n - 1, xs.tail)

val list = new Cons(1,new Cons(2, new Cons(3,new Nil)))

nth(2, list)
nth(-2, list)
