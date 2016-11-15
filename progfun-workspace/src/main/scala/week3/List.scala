package week3

import java.util.NoSuchElementException

/**
  * Created by chodonghyun on 2016. 6. 14..
  */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T]{
  def isEmpty:Boolean = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}