object tests {


  val w = "Hello"
  (w.toUpperCase groupBy ((char: Char) => char)).toList
    .map { case (letter, nletters) => (letter, nletters.length) }


  val s = List("Hello","Dear")
  s.reduceLeft((fullword,word)=>fullword.concat(word))

}