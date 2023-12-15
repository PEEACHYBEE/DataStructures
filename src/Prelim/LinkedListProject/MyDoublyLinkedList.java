package Prelim.LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 20, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
public class MyDoublyLinkedList <T> implements MyList<T> {

    /**Inner class for the node of a doubly linked list*/
    private class Node {
        T data;           //Data stored in the node
        Node next;        //Pointer to the next node
        Node prev;        //Pointer to the previous node

        //Constructor initializes the node with data
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;  //Head of the list
    private Node tail = null;  //Tail of the list
    private int size = 0;      //Size of the list

    //Returns the current size of the list
    @Override
    public int getSize() {
        return size;
    }

    /**Inserts a new element at the end of the list*/
    @Override
    public void insert(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**Returns the element if it's found in the list, else null*/
    @Override
    public T getElement(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) return current.data;
            current = current.next;
        }
        return null;
    }

    /**Deletes an element from the list and returns true, else returns false*/
    @Override
    public boolean delete(T data) {
        Node current = head;
        if (head != null && head.data.equals(data)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            return true;
        }
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        if (current == null) return false;
        if (current.next != null) current.next.prev = current.prev;
        if (current.prev != null) current.prev.next = current.next;
        if (current == tail) tail = current.prev;
        size--;
        return true;
    }

    /**Returns the index of an element if it's in the list, else returns -1*/
    @Override
    public int search(T data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /**Displays all elements in the list*/
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

        //Inserting elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        //Display original list
        System.out.println("Original list:");
        list.display();

        //Deleting and displaying list
        System.out.println("\nAfter deleting 20:");
        list.delete(20);
        list.display();

        //Searching and displaying index
        System.out.println("\nElement 30 found at index: " + list.search(30));
    }
}
