trait Expr {
  //Classification
  def isNumber: Boolean
  def isSum: Boolean
  //Accessor
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  override def isSum: Boolean = false
  override def numValue: Int = n
  override def leftOp: Expr = throw new Error("Number.leftOp")
  override def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(e1:Expr, e2: Expr) extends Expr{
  //Classification
  def isNumber: Boolean = false
  def isSum: Boolean = true
  //Accessor
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

def eval(e: Expr): Int = {
  if (e.isNumber) e.numValue
  else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else throw new Error("Unknown expression " + e)
}

eval(new Sum(new Number(1),new Number(2)))

//class Prod(e1: Expr, e2: Expr) extends Expr
//class Var(x: String) extends Expr
//to integrate Pros and Var into the hierarchy, how many method definitions do you need?
//25!! isVal , isProd, name, need 3 more. 3 * 3 + 8 * 2 = 25


//hacky solution, isInstanceOf[T], asInstanceOf[T] => non solution

def eval2(e: Expr): Int = {
  if (e.isInstanceOf[Number]) e.asInstanceOf[Number].numValue
  else if (e.isInstanceOf[Sum]) {
    eval2(e.asInstanceOf[Sum].leftOp)
    + eval2(e.asInstanceOf[Sum].rightOp)
  }
  else throw new Error("Unknown expression " + e)
}

//Solution1: Object-Oriented Decomposition
// def eval: Int
// def eval: Int = n
// def eval: Int = e1.eval + e2.eval

