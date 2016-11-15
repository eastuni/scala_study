package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by chodonghyun on 2016. 6. 6..
  */
@RunWith(classOf[JUnitRunner])
class MyTestSuite extends FunSuite {

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 200))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = new Set() {1,2,3,4,5,6,7,8,9,10}
    val s5 = new Set() {5,6,7,8,9,10,11,12,13,14}
  }

  test("singletonSet(1) contains 1") {

    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("filter test"){
    new TestSets{
      assert(contains(filter(s4,x => x / 2 == 0),2),"filter 2")
      assert(contains(filter(s4,x => x / 2 == 0),4),"filter 4")
    }


  }
}
