package hackercup.y2015.round1

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
object Homework {

  def findWithPrimacity(a: Int, b: Int, k: Int): Int = {

    def primacity(number: Int): Int = {

      // sieve of Eratosthenes by Odersky
      def sieve(s: Stream[Int]): Stream[Int] = {
        s.head #:: sieve(s.tail.filter(_ % s.head != 0))
      }
      val primes = sieve(Stream.from(2))

      primes.takeWhile(_ <= number).filter(number % _ == 0).length
    }

    val occurrences = for {
      i <- a to b
      if primacity(i) == k
    } yield i

    occurrences.size
  }


}
