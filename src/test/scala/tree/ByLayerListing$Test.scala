package tree

import base.UnitSpec
import tree.ByLayerListing.Node

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
class ByLayerListing$Test extends UnitSpec {

  val tree = Node(2, Some(Node(3, Some(Node(5, None, None)), None)), Some(Node(4, None, Some(Node(7, None, None)))))

  "A tree" should "traverse" in {

    val result = ByLayerListing.list(tree)

    result shouldBe List("1: 2", "2: 3,4", "3: 5,7")

  }

}
