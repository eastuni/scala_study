//Haskell is a functional programming language that uses
// lazy evaluation by default.
// Scala uses strict evaluation by default, but allows
// lazy evaluation of value definitions with the lazy val form
//lazy val x = expr



def expr = {
  val x = {print("x"); 1} // x
  lazy val y ={print("y");2} // skip
  def z = {print("z");3} // skip

  z+y+x+z+y+x // z y skip z skip skip
}

expr
