package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 22, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
public class MyDoublyLinkedCircularList <E> implements MyList<E> {
    //Node class for the doubly linked list
    private class Node {
        E data;
        Node next;
        Node prev;

        public Node(E data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }

    private Node head = null; //Head node of the list
    private int size = 0; //Size to keep track of the number of elements in the list

    /**Returns the size of the list*/
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    @Override
    public E getElement(E data) {
        Node temp = head;
        if (head == null) return null;
        do {
            if (temp.data.equals(data)) return temp.data;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    @Override
    public boolean delete(E data) {
        Node temp = head;
        if (head == null) return false;

        do {
            if (temp.data.equals(data)) {
                if (size == 1) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) head = temp.next;
                }
                size--;
                return true;
            }
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    @Override
    public int search(E data) {
        Node temp = head;
        int index = 0;
        if (head == null) return -1;

        do {
            if (temp.data.equals(data)) return index;
            temp = temp.next;
            index++;
        } while (temp != head);

        return -1;
    }

    /**Modified display to show circular nature by displaying the first two nodes after the last node*/
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        //Emphasize circular nature
        System.out.print(head.data + " <-> " + head.next.data + " <-> " + head.next.data + " <-> " + head.next.data +  " ... (and back to start)");
    }

    public static void main(String[] args) {
        MyDoublyLinkedCircularList<Integer> list = new MyDoublyLinkedCircularList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        //Display original list
        System.out.println("\nOriginal list:");
        list.display();

        //Deleting and displaying list
        System.out.println("\nAfter deleting 20:");
        list.delete(20);
        list.display();

        //Searching and displaying index
        System.out.println("\nElement 30 found at index: " + list.search(30));
    }
}
