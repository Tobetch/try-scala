class Trunk {
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }
};

// A Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class CalcExp {
    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public static void printTree(Node root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        } else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        if (root.data == 0) {
            System.out.println(" ");
        } else {
            System.out.println(" " + root.data);
        }

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }

    public static void main(String[] args) {
        // Construct above tree
        int x = 5;
        int y = 7;
        Node root = new Node();
        root.left = new Node();
        root.right = new Node();
        root.left.left = new Node(x);
        root.left.right = new Node(x);
        root.right.left = new Node(7);
        root.right.right = new Node(y);

        // print constructed binary tree
        printTree(root, null, false);
    }
}