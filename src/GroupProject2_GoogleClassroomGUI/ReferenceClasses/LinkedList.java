package GroupProject2_GoogleClassroomGUI.ReferenceClasses;
/**
 * The `LinkedList` class is an implementation of the `ListInterface` interface
 * using a singly linked list data structure. It provides methods for adding, inserting,
 * removing, and accessing elements in the list.
 *
 * @param <T> The type of elements stored in the linked list.
 */
public class LinkedList <T> implements ListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs an empty linked list with no elements.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Gets the head node of the linked list.
     *
     * @return The head node of the linked list.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Gets the tail node of the linked list.
     *
     * @return The tail node of the linked list.
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Sets the head node of the linked list.
     *
     * @param head The new head node to set.
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Sets the tail node of the linked list.
     *
     * @param tail The new tail node to set.
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public void add(T element) {
        // add method
    }

    @Override
    public void insert(int index, T element) {
        //  insert method
    }

    @Override
    public void remove(int index) {
        //  remove method
    }

    @Override
    public int size() {
        //  size method
        return size;
    }

    @Override
    public boolean isEmpty() {
        //  isEmpty method
        return size == 0;
    }

    @Override
    public T get(int index) {
        //  get method
        return null;
    }

    @Override
    public int indexOf(T element) {
        //  indexOf method
        return -1;
    }

    @Override
    public void clear() {
        // clear method
    }
}
