case class Trunk(var prev: Trunk, var str: String)

// A Binary Tree Node
class Node(var data: Int, var left: Node = null, var right: Node = null)

object CalcExp {
  def showTrunks(p: Trunk): Unit = {
    if (p == null) {
      return
    }

    showTrunks(p.prev)
    print(p.str)
  }

  def printTree(root: Node, prev: Trunk, isLeft: Boolean): Unit = {
    if (root == null) {
      return
    }

    val prev_str = "    "
    val trunk = Trunk(prev, prev_str)

    printTree(root.right, trunk, true)

    if (prev == null) {
      trunk.str = "———"
    } else if (isLeft) {
      trunk.str = ".———"
      trunk.prev.str = "   |"
    } else {
      trunk.str = "`———"
      prev.str = prev_str
    }

    showTrunks(trunk)
    if (root.data == 0) {
      println(" ")
    } else {
      println(" " + root.data)
    }

    if (prev != null) {
      prev.str = prev_str
    }
    trunk.str = "   |"

    printTree(root.left, trunk, false)
  }

  def main(args: Array[String]): Unit = {
    // Construct above tree
    val x = 5
    val y = 7
    val root = new Node(0)
    root.left = new Node(0)
    root.right = new Node(0)
    root.left.left = new Node(x)
    root.left.right = new Node(x)
    root.right.left = new Node(7)
    root.right.right = new Node(y)

    // print constructed binary tree
    printTree(root, null, false)
  }
}
