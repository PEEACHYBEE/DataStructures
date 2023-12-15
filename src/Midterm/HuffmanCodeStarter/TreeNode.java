package Midterm.HuffmanCodeStarter;
/**Name: ENCARNACION, Ma. Earl Freskkie A
 * Programming Date: October 21, 2023*/

public class TreeNode implements Comparable<TreeNode> {
    int count;
    char symbol;
    TreeNode left;
    TreeNode right;

    public TreeNode(){
        count = 0;
        symbol = 'x';
        left = null;
        right = null;
    }

    /**
     * Parameterized constructor.
     * @param count   Frequency/count of the symbol.
     * @param symbol  Symbol/character stored in this node.
     * @param left    Left child of this node.
     * @param right   Right child of this node.
     */
    public TreeNode(int count, char symbol, TreeNode left, TreeNode right){
        this.count = count;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public int getCount(){
        return count;
    }

    public char getSymbol(){
        return symbol;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    /**
     * Compare two TreeNode objects based on their count.
     * @param other Another TreeNode to compare with.
     * @return -1 if this node has a lower count, 0 if equal, 1 if this node has a higher count.
     */
    public int compareTo(TreeNode other){
        if (this.getCount() == other.getCount())
            return 0;
        else
        if (this.getCount() < other.getCount())
            return -1;
        else
            return -1;
    }
}
