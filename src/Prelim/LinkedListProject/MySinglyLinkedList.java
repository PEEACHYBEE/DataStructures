package Prelim.LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 14, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
public class MySinglyLinkedList<E> implements MyList<E> {
    //Inner class for the node of a singly linked list
    private class Node {
        E data;     //Data stored in the node
        Node next;  //Pointer to the next node

        //Constructor initializes the node with data
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;  //Head of the list
    private int size = 0;      //Size of the list

    /**Returns the current size of the list*/
    @Override
    public int getSize() {
        return size;
    }

    /**Inserts a new element at the end of the list*/
    @Override
    public void insert(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**Returns the element if it's found in the list, else null*/
    @Override
    public E getElement(E data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) return current.data;
            current = current.next;
        }
        return null;
    }

    /**Deletes an element from the list and returns true, else returns false*/
    @Override
    public boolean delete(E data) {
        Node current = head;
        Node prev = null;

        if (head != null && head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) return false;

        prev.next = current.next;
        size--;
        return true;
    }

    /**Returns the index of an element if it's in the list, else returns -1*/
    @Override
    public int search(E data) {
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
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        //Instantiate a new linked list of type String
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();

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
