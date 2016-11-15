def sum(f:Int => Int): (Int,Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) +sumF(a+1, b)
  sumF
}

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorials = sum(fact)

def fact(x: Int): Int = if (x == 0 ) 1 else fact(x-1)
def cube(x: Int): Int = x * x * x
sumInts(1,4)
sumCubes(4,5)
sumFactorials(1,4)
sumCubes(1,10) + sumFactorials(10,20)

sum (cube) (1,10)