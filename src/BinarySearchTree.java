import java.util.LinkedList;
import java.util.Queue;
/*
 * Liam Jasper Gimbel
 * 25012024\n
 * this code is an edited version of code provided by Chevan Richards
 */

/*
 * 010220242
 * this is an edited version of previously edited code made to work for the desired assignment.
 * 28022024
 * this is a fork of previously edited code
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        double[] values = {10.22,55,33.3,5,17};
        BinaryTree myTree = new BinaryTree(values[0]);
        for (int i = 1; i < values.length ; i++) {
            myTree.addNode(values[i]);

        }

        myTree.printPreOrder(BinaryTree.headptr);
        myTree.printInPostOrderTree(BinaryTree.headptr);
        myTree.printInOrderTree(BinaryTree.headptr);
        myTree.removeNode(33.3);
        myTree.printBreadthFirst();
        myTree.addNode(133.25);
        myTree.printBreadthFirst();
        System.out.println("Tree hight = "+ myTree.getHeight());
    }
}
class Node{
    public double data;
    public Node left;

    public Node right;
    public Node(double data){
        this.data = data;
        this.left = null;
        this.right = null;

    }
}
class BinaryTree {

    public static Node headptr;

    BinaryTree(double data) {
        headptr = new Node(data);
    }

    public static Node addNode(Node current, double data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addNode(current.left, data);
        } else if (data > current.data) {
            current.right = addNode(current.right, data);

        } else {
            return current;
        }
        return current;
    }
    public int getHeight() {
        return getHeight(headptr);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);


        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void addNode(double data) {
        Node current = headptr;
        if (current == null) {
            new Node(data);
            return;
        }

        if (data < current.data) {
            current.left = addNode(current.left, data);
        } else if (data > current.data) {
            current.right = addNode(current.right, data);

        }
    }

    public void printInOrderTree(Node current) {
        if (current == null) {
            return;
        }

        printInOrderTree(current.left);

        System.out.println(current.data + " ");

        printInOrderTree(current.right);
    }
    public void removeNode(double data) {
        headptr = removeNode(headptr, data);
    }

    private Node removeNode(Node current, double data) {
        if (current == null) {
            return null;
        }

        if (data < current.data) {
            current.left = removeNode(current.left, data);
        } else if (data > current.data) {
            current.right = removeNode(current.right, data);
        } else {
            if (current.left ==null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.data= findMinimumValue(current.right);
            current.right = removeNode(current.right, current.data);
        }

        return current;
    }

    private double findMinimumValue(Node node) {
        return (node.left == null) ? node.data : findMinimumValue(node.left);
    }

    public void printInPostOrderTree(Node current) {
        if (current == null) {
            return;
        }

        printInPostOrderTree(current.left);
        printInPostOrderTree(current.right);
        System.out.println(current.data + " ");

    }

    public void printPreOrder(Node current) {
        if (current == null) {
            return;
        }
        printPreOrder(current.right);
        printPreOrder(current.left);
        System.out.println(current.data);
    }
    public void printBreadthFirst() {
        if (headptr == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(headptr);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.println();
    }
}

