package hackercup.y2015.round1

import base.UnitSpec
import org.scalatest.FunSuite

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
class Autocomplete$Test extends UnitSpec {

  "#1" should "be 11" in {
    val words = List("hi", "hello", "lol", "hills", "hill")

    val result = Autocomplete.solve(words)

    result shouldBe 11

  }

}
