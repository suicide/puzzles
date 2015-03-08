package hackercup.y2015.round1

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * TODO: Comment
 *
 * @author Patrick Sy (patrick.sy@get-it.us)
 */
object Autocomplete {

  case class Node(value: String, children: mutable.Map[Char, Node] = new mutable.HashMap())

  def solve(words: Seq[String]): Int = {

    def buildTrie(words: Seq[String]): Node = {
      // TODO build trie without skipping
      val sortedWords = words.sorted

      val root = Node("")

      @tailrec
      def addWord(word: String, node: Node): Unit = {
        val depth = node.value.length
        val keyChar = word(depth)

        val child = root.children.get(keyChar)
        child match {
          case Some(n) =>
            addWord(word, n)
          case None =>
            node.children.put(keyChar, Node(word))
        }
      }

      sortedWords.foreach(addWord(_, root))

      root
    }

    def minType(word: String, trie: Node): Int = {

      @tailrec
      def minTypeInternal(word: String, node: Node, chars: Int): Int = {
        word match {
          case node.value => chars + 1
          case _ => {
            val searchChar = word(chars)
            val child = node.children.get(searchChar)
            child match {
              case Some(n) =>
                minTypeInternal(word, n, node.value.length)
              case None => throw new RuntimeException("word not found in trie")
            }
          }
        }
      }

      minTypeInternal(word, trie, 0)
    }

    val trie = buildTrie(words)

    words.map(minType(_, trie)).sum
  }

}
