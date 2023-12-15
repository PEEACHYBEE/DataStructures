package Midterm.TreePackageDemo;
/**Removed unnecessary getters and setters since they are not used in this code
 * @name: ENCARNACION, Ma. Earl Freskkie
 * @since: November 7, 2023
 * */
public class Node<T>{
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value, Node<T>left, Node<T>right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getLeft(){
        return left;
    }

    public Node<T> getRight(){
        return right;
    }
