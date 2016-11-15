package patmat

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite2 extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}

  test("encode a very short text should be identity") {
    new TestTrees {
      encode(t1)("ab".toList)
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  test("decode and encode a very short2 text should be identity") {
    new TestTrees {
      assert(decode(t2, encode(t2)("abdab".toList)) === "abdab".toList)
    }
  }
  test("decode and encode a long text should be identity") {
    new TestTrees {

      val long_text = "iterature from 45 BC, making it over 2000 years old.".toList
      val t3=Fork(Fork(Fork(Leaf('a',26),Leaf('r',27),List('a', 'r'),53),Fork(Fork(Leaf('c',14),Fork(Leaf('g',7),Fork(Leaf('C',4),Leaf('b',4),List('C', 'b'),8),List('g', 'C', 'b'),15),List('c', 'g', 'C', 'b'),29),Fork(Leaf('l',15),Fork(Fork(Fork(Fork(Leaf('5',1),Leaf('B',1),List('5', 'B'),2),Fork(Leaf('x',1),Leaf('4',1),List('x', '4'),2),List('5', 'B', 'x', '4'),4),Fork(Fork(Leaf('M',1),Leaf('H',1),List('M', 'H'),2),Fork(Leaf('2',1),Leaf('R',1),List('2', 'R'),2),List('M', 'H', '2', 'R'),4),List('5', 'B', 'x', '4', 'M', 'H', '2', 'R'),8),Leaf(',',8),List('5', 'B', 'x', '4', 'M', 'H', '2', 'R', ','),16),List('l', '5', 'B', 'x', '4', 'M', 'H', '2', 'R', ','),31),List('c', 'g', 'C', 'b', 'l', '5', 'B', 'x', '4', 'M', 'H', '2', 'R', ','),60),List('a', 'r', 'c', 'g', 'C', 'b', 'l', '5', 'B', 'x', '4', 'M', 'H', '2', 'R', ','),113),Fork(Fork(Leaf('o',33),Leaf('e',34),List('o', 'e'),67),Leaf(' ',69),List('o', 'e', ' '),136),List('a', 'r', 'c', 'g', 'C', 'b', 'l', '5', 'B', 'x', '4', 'M', 'H', '2', 'R', ',', 'o', 'e', ' '),249)
      assert(decode(t3, encode(t3)(long_text)) === long_text)
    }
  }

}
