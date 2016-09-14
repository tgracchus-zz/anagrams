
import forcomp.Anagrams._

object test {

  1 + 1
  val w = "Hello"
  (w.toUpperCase groupBy ((char: Char) => char)).toList
    .map { case (letter, nletters) => (letter, nletters.length) }


  val s = List("Hello", "Dear")
  s.reduceLeft((fullword, word) => fullword.concat(word))


   val test: Map[Occurrences, List[Word]] = dictionary.groupBy(word=>wordOccurrences(word))

}






