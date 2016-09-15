
import forcomp.Anagrams._

object test {

  /* 1 + 1
   val w = "Hello"
   (w.toUpperCase groupBy ((char: Char) => char)).toList
     .map { case (letter, nletters) => (letter, nletters.length) }


   val s = List("Hello", "Dear")
   s.reduceLeft((fullword, word) => fullword.concat(word))


   val test: Map[Occurrences, List[Word]] = dictionary.groupBy(word => wordOccurrences(word))

   val testOccurences: Occurrences = List(('H', 1), ('M', 3), ('L', 3))
   testOccurences take 2
   testOccurences drop 2

   List(('L', 3)) take 1
   List(('L', 3)) drop 1

   def combinations(occurrences: Occurrences): List[Occurrences] =
     if (occurrences.isEmpty)
       List(List())
     else {
       for {
         index <- 0 to occurrences.length
         elements <- occurrences.combinations(index)
       } yield elements
     }.toList


   combinations(testOccurences)
 */
  val x = wordOccurrences("hehoa")
  val xmap = x.toMap
  val y = wordOccurrences("He")


  val x1 = y.map(a => (a._1, xmap(a._1) - a._2)).filter(_._2 > 0) union (x diff y)


  def expand(occurrences: Occurrences): Occurrences =
    if (occurrences.isEmpty)
      List()
    else {
      {
        for {
          occurrence <- occurrences
          index <- 1 to occurrence._2
        } yield (occurrence._1, index)
      }
    }


  def combinations(occurrences: Occurrences): List[Occurrences] = {
    if (occurrences.isEmpty)
      List(List())
    else {
      val expandedList = expand(occurrences)
      List() :: {
        for {
          index <- 1 to occurrences.length
          rest <- (expandedList combinations (index))
        } yield rest
      }.toList.filter(occurrence => occurrence.groupBy(_._1).forall(hashelem => hashelem._2.length == 1))
    }
  }

  combinations(wordOccurrences("abba"));


}