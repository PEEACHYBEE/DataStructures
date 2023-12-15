package Midterm.TreePackageDemo;
/**@name: ENCARNACION, Ma. Earl Freskkie A.
 * @since: November 7, 2023
 * */

public class Tree<T> {
    private Node<T> root;

    public Tree(){
        root = null;
    }

    public void setRoot(Node<T> root){
        this.root = root;
    }

    public Node<T>getRoot(){
        return root;
    }
}
