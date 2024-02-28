/**
 * Liam Jasper Gimbel
 * 25012024\n
 * this code is an edited version of code provided by Chevan Richards
 */

/**
 * 010220242
 * this is an edited version of previously edited code made to work for the desired assignment.
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        int[] values = {10,20,55,33,3,5,17};
        BinaryTree myTree = new BinaryTree(values[0]);
        for (int i = 1; i < values.length ; i++) {
            myTree.addNode(values[i]);

        }

        myTree.printPreOrder(BinaryTree.headptr);
    }
}
class Node{
    public int data;
    public Node left;

    public Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree {

    public static Node headptr;

    BinaryTree(int data){
        headptr = new Node(data);
    }
    public static Node addNode(Node current, int data){
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addNode(current.left, data);
        } else if (data > current.data) {
            current.right = addNode(current.right, data);

        } else {
            return current;
        } return current;
    }

    public static void addNode(int data){
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
    public void printInOrderTree(Node current){
        if (current == null){
            return;}

        printInOrderTree(current.left);

        System.out.println(current.data + " ");

        printInOrderTree(current.right);
    }
    public void printInPostOrderTree(Node current){
        if (current == null){
            return;}

        printInPostOrderTree(current.left);
        printInPostOrderTree(current.right);
        System.out.println(current.data + " ");

    }
    public void printPreOrder(Node current){
        if (current == null) {
            return;
        }
        printPreOrder(current.right);
        printPreOrder(current.left);
        System.out.println(current.data);
    }

}

