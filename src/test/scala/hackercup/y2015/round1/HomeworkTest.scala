package hackercup.y2015.round1

import base.UnitSpec
import org.scalatest.FunSuite

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
class HomeworkTest extends UnitSpec {

  "Between 5 and 15 with primacity 2" should "be 5" in {

    val result = Homework.findWithPrimacity(5, 15, 2)

    result shouldBe 5

  }

  "Between 2 and 10 with primacity 1" should "be 7" in {

    val result = Homework.findWithPrimacity(2, 10, 1)

    result shouldBe 7

  }

  "Between 24 and 42 with primacity 3" should "be 2" in {

    val result = Homework.findWithPrimacity(24, 42, 3)

    result shouldBe 2

  }

  "Between 1000000 and 1000000 with primacity 1" should "be 0" in {

    val result = Homework.findWithPrimacity(1000000, 1000000, 1)

    result shouldBe 0

  }

  "Between 1000000 and 1000000 with primacity 2" should "be 1" in {

    val result = Homework.findWithPrimacity(1000000, 1000000, 2)

    result shouldBe 1

  }

}
