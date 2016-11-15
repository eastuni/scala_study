val xs = Stream.cons(1,Stream.cons(2,Stream.empty))
Stream(1,2,3)

def streamRange(lo: Int, hi:Int): Stream[Int] ={
  print(lo +" ")
  if (lo >=hi) Stream.empty
  else Stream.cons(lo,streamRange(lo+1,hi))
}

streamRange(1,10).take(3).toList


def listRange(lo:Int, hi: Int): List[Int] =
  if(lo >= hi) Nil
  else lo :: listRange(lo+1,hi)

listRange(1,5)


// x #:: xs

//streamRange(1013,10000).filter(isPrime).apply(0)

