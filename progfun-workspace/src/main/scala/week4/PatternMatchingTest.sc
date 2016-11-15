// Decomposition
// Attempts seen previously
// Classification and access methods: quadratic explosion
// Type test and cases: unsafe, low-level
// Object-oriented decomposition: dose not always work,
// need to touch all classes to add a new method


trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
  def show: String = this match {
    case Number(x) => x.toString
    case Sum(l, r) => l.show + " + " + r.show
  }
}

case class Number(n: Int) extends Expr

case class Sum(e1:Expr, e2: Expr) extends Expr

//object Number {
//  def apply(n: Int) = new Number(n)
//}

//object Sum {
//  def apply(e1: Expr, e2: Expr): Sum = new Sum(e1, e2)
//}

//object Expr

Sum(Number(1),Number(3)).show

Sum(Number(1),Number(3)).eval




