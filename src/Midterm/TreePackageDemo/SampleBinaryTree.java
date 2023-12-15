package Midterm.TreePackageDemo;

/**Algorithm:
 * 1. The SampleBinaryTree class is the entry point for the program.
 *    In the main method, an instance of SampleBinaryTree is created,
 *    and the run method is called
 * 2. Inside the run method, a Tree object is created to represent a binary tree of integers
 * 3. Five leaf nodes (leaf1, leaf2, leaf3, leaf4, leaf5) are created, each containing an
 *    integer value and having no left or right children.
 * 4. Three internal nodes (node3, node2, node4) are created, each with a value and references to left and right child nodes.
 *    These internal nodes represent the structure of the binary tree.
 * 5. The binary tree's root node is set with a value of 83 and references to node2 and node4,
 *    creating the full binary tree structure.
 * 6. The printPreOrder method is called with the root node as an argument to perform a pre-order traversal of the
 *    binary tree. Pre-order traversal prints the value of the current node, then recursively traverses the left
 *    subtree and the right subtree.
 * 7. The printPreOrder method uses a recursive approach to traverse the binary tree. It prints the value of each node and then
 *    explores its left and right children in a pre-order sequence, meaning it visits the root node first,
 *    then its left subtree, and finally its right subtree
 *
 * @name: ENCARNACION, Ma. Earl Freskkie A.
 * @since: November 7, 2023
 * */
public class SampleBinaryTree {
    public static void main(String[] args) {
        SampleBinaryTree test;
        try {
            test = new SampleBinaryTree();
            test.run();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.exit(0);
    } // end of main method
    public void run (){
        Tree<Integer> tree = new Tree<Integer>();
        Node<Integer> leaf1 = new Node<Integer>(21, null, null);
        Node<Integer> leaf2 = new Node<Integer>(28, null, null);
        Node<Integer> leaf3 = new Node<Integer>(5, null, null);
        Node<Integer> leaf4 = new Node<Integer>(27, null, null);
        Node<Integer> leaf5 = new Node<Integer>(3, null, null);
        Node<Integer> node3 = new Node<Integer>(53,leaf1,leaf2);
        Node<Integer> node2 = new Node<Integer>(66, node3,leaf3);
        Node<Integer> node4 = new Node<Integer>(55, leaf4, leaf5);

        tree.setRoot(new Node<Integer>(83, node2, node4));
        printPreOrder(tree.getRoot());
    } // end of run
    public void printPreOrder(Node<Integer> node){
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }
}
