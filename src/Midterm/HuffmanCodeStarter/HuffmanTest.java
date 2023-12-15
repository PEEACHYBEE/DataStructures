package Midterm.HuffmanCodeStarter;
import java.util.PriorityQueue;
/**Name: ENCARNACION, Ma. Earl Freskkie A
 * Programming Date: October 21, 2023*/

public class HuffmanTest {

    /**
     * Recursive function to print the Huffman code for each character in the tree.
     * @param root Current node in the Huffman tree.
     * @param s    Current Huffman code for the character.
     */
    public static void printCode(TreeNode root, String s) {

        //If the current node is a leaf and contains a letter
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getSymbol())) {
            System.out.println(root.getSymbol() + " | " + s);
            return;
        }

        printCode(root.getLeft(), s + "0"); //Recursive case: go left and append "0" to the code
        printCode(root.getRight(), s + "1"); //Recursive case: go right and append "1" to the code
    }

    public static void main(String[] args) {

        int n = 8; //Number of characters
        char[] symbolArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int[] symbolFrequency = {30, 12, 13, 20, 45, 2, 2, 7};

        //Using a priority queue to create the Huffman tree.
        //Nodes with the lowest frequency have the highest priority.
        PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<TreeNode>(n);

        //Initializing the priority queue with the symbols and their frequencies
        for (int i = 0; i < n; i++) {
            TreeNode huffmanNode = new TreeNode();
            huffmanNode.setSymbol(symbolArray[i]);
            huffmanNode.setCount(symbolFrequency[i]);
            huffmanNode.setLeft(null);
            huffmanNode.setRight(null);
            huffmanTree.add(huffmanNode);
        }

        TreeNode root = null;

        //Building the Huffman tree by combining the two nodes with the lowest frequencies
        while (huffmanTree.size() > 1) {
            TreeNode t = huffmanTree.peek();
            huffmanTree.poll();

            TreeNode u = huffmanTree.peek();
            huffmanTree.poll();

            TreeNode v = new TreeNode();
            v.setCount(t.getCount() + u.getCount());
            v.setSymbol('-'); //Non-leaf nodes don't store any particular character
            v.setLeft(t);
            v.setRight(u);
            root = v;

            huffmanTree.add(v);
        }

        //Printing the Huffman codes for each character
        System.out.println("\n Char | Huffman Code ");
        System.out.println("---------------------");
        printCode(root, "");

        System.out.println();
        System.out.println("Tested By: ~Encarnacion, Ma. Earl Freskkie~");
    }
}
