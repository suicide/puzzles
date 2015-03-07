package tree

import scala.annotation.tailrec

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
object ByLayerListing {

  case class Node(value: Int, left: Option[Node], right: Option[Node])

  def list(root: Node): Seq[String] = {

    @tailrec
    def evalLayer(layer: Seq[Node], depth: Int, output: Seq[String]): Seq[String] = {

      layer match {
        case Nil => output
        case _ => {

          val children = for {
            node <- layer
            o <- List(node.left, node.right)
            n <- o
          } yield n

          val line = s"$depth: " + layer.map(_.value).mkString(",")

          evalLayer(children, depth + 1, output :+ line )
        }
      }
    }

    evalLayer(List(root), 1, Nil)
  }

}
