val w = "AdlsjdflEasdfsad";

w.toLowerCase.groupBy((el:Char)=> el).toList.sorted

type Word = String

type Sentence = List[Word]

type Occurrences = List[(Char, Int)]
def wordOccurrences(w: Word): Occurrences = {
  (for (
    (char, list) <- w.groupBy((element:Char) => element.toLower).toList
  ) yield (char, list.length)).sortBy(_._2)
}

wordOccurrences("alksdjflkjlwekjasdASADFASDFlfkjlksadlkdjasf")

val s = List("asdf","asdf","qwera","ljlkjsdf","adsfda")

wordOccurrences(s.foldRight(new String())(_ ++ _))

s.foldRight(new String())(_ ++ _)

for(i <- 1 to 10) yield i
val dd = for(i <- 1 to 3;
a <- i to i + 3) yield (i , a)

dd.length
