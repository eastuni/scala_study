import objsets.{Empty, Tweet}

val set1 = new Empty
val set2 = set1.incl(new Tweet("a", "a body", 20))
val set3 = set2.incl(new Tweet("b", "b body", 20))
val c = new Tweet("c", "c body", 7)
val d = new Tweet("d", "d body", 9)
val set4c = set3.incl(c)
val set4d = set3.incl(d)
val set5 = set4c.incl(d)

set5.union(set1)
set1.union(set5)

set1.filter(tw => tw.user == "a")
set5 filter(tw => tw.user == "a")

set1.filterAcc(tw => true,set2)

set2.filterAcc(tw => true,set1)
set5.descendingByRetweet
