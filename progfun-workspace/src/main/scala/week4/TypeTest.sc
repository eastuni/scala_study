
abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet {
  override def toString = "{" + left + element + right + "}"
  def contains(x: Int): Boolean =
    if (x < element) left contains x
    else if (x > element) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < element) new NonEmpty(element, left incl x, right);
    else if (x > element) new NonEmpty(element, left, right incl x);
    else this
  def union(other: IntSet): IntSet = ((left union right) union other) incl element
}

val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty,Empty))
//val b: Array[IntSet] = a //error Array NonCovariant
//b(0) = Empty
val s: NonEmpty = a(0)

type A = IntSet => NonEmpty
type B = NonEmpty => IntSet





