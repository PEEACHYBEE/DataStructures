package Midterm.GroupProject1.Stack;

public class MyStack <T> extends MyStackInterface<T> {
    Node<T> top;
    int count;

    public MyStack(){
        top = null;
        count = 0;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if(isEmpty()){
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        count +=1;
        return;
    }

    @Override
    public T pop() throws StackUnderflowException {
        T topElement = null;
        if(isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else{
            topElement = top.getDatum();
            if(count == 1){
                top = null;
            } else {
                top = top.getNext();
            }
            count -= 1;
        }
        return topElement;
    }

    @Override
    public T peek() throws StackUnderflowException {
        T topElement = null;
        if(isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else {
            topElement = top.getDatum();
        }
        return topElement;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString(String delimeter) throws StackUnderflowException {
        return null;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getDatum();
    }
}
