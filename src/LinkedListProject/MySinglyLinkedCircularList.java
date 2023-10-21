package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 22, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
public class MySinglyLinkedCircularList <E> implements MyList<E> {

    private Node head = null;  //Starting point of the list
    private int size = 0;      //Track the number of elements in the list
    private Node tail = null; //Ending point of the list

    /**Node inner class for the circular linked list*/
    private class Node {
        E data;           //Data held in the node
        Node next;        //Pointer to the next node

        public Node(E data) {
            this.data = data;
            this.next = this;  //Defaulting to itself to make it circular by default
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    /**Insert a new node at the end and make it point to the head*/
    @Override
    public void insert(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    /**Find and return a node with the specified data, else return null*/
    @Override
    public E getElement(E data) {
        Node current = head;
        if (current == null) return null;

        do {
            if (current.data.equals(data)) return current.data;
            current = current.next;
        } while (current != head);

        return null;
    }

    /**Delete a node with the specified data and return true, else return false*/
    @Override
    public boolean delete(E data) {
        Node current = head;
        Node prev = null;

        if (current == null) return false;

        //Handle case where head needs to be deleted
        if (current.data.equals(data)) {
            while (current.next != head) {
                current = current.next;
            }
            if (current == head) {
                head = null;
            } else {
                head = head.next;
                current.next = head;
            }
            size--;
            return true;
        }

        prev = current;
        current = current.next;

        while (current != head) {
            if (current.data.equals(data)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    /**Return the index of a node if it's in the list, else returns -1*/
    @Override
    public int search(E data) {
        Node current = head;
        int index = 0;

        if (current == null) return -1;

        do {
            if (current.data.equals(data)) return index;
            current = current.next;
            index++;
        } while (current != head);

        return -1;
    }

    /**Print all nodes in the circular list*/
    public void display() {
        if (head == null) return;

        Node temp = head;
        int iterations = 3; // Number of cycles
        int count = 0; // Keep track of the number of elements printed

        while (iterations > 0) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;

            if (count == size) { // When one cycle is completed
                iterations--;
                count = 0;
            }
        }
        System.out.println("... repeats ...");
    }

    public static void main(String[] args) {
        MySinglyLinkedCircularList<Integer> list = new MySinglyLinkedCircularList<>();

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
