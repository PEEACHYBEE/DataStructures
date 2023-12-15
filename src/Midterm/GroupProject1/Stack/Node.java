package Midterm.GroupProject1.Stack;

import javax.security.auth.callback.Callback;

public class Node <T>{
    private Callback callback;
    T datum;
    Node<T> next;

    public Node() {
        setDatum(null);
        setNext(null);
    }

    public Node(T datum) {
        setDatum(datum);
        setNext(null);
    }

    public T getDatum() {
        return datum;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setDatum(T datum) {
        this.datum = datum;
    }

    public void setNext(Node<T> node) {
        next = node;
    }
}
