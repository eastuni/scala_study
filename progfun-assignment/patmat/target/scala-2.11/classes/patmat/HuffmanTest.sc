import patmat.Huffman._


val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)

encode(t1)("ab".toList)

val en = encode(t2)("abdab".toList)

decode(t2,en)

val t3 = createCodeTree("aabbb".toList);


createCodeTree("aabbbdddd".toList);