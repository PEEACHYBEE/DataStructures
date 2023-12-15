package Prelim.GroupProject2_GoogleClassroomGUI.ReferenceClasses;
/**
 * The `Node` class represents a node in a linked data structure, such as a singly linked list.
 * Each node contains an element of type T (the "info" field) and a reference to the next node (the "link" field).
 *
 * @param <T> The type of data stored in the node.
 */
public class Node<T> {
    private T info;
    private Node<T> link; // Reference to the next node

    /**
     * Constructs an empty node with no data and no reference to the next node.
     */
    public Node() {
    }

    /**
     * Constructs a node with the specified data and no reference to the next node.
     *
     * @param data The data to be stored in the node.
     */

    public Node(T data) {
        info = data;
        link = null;
    }

    /**
     * Constructs a node with the specified data and a reference to the next node.
     *
     * @param data      The data to be stored in the node.
     * @param nextNode  The next node to which this node is linked.
     */

    public Node(T data, Node<T> nextNode) {
        info = data;
        link = nextNode;
    }

    /**
     * Gets the data stored in this node.
     *
     * @return The data stored in the node.
     */

    public T getInfo() {
        return info;
    }

    /**
     * Sets the data stored in this node.
     *
     * @param info The data to be stored in the node.
     */

    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Gets the reference to the next node linked to this node.
     *
     * @return The next node linked to this node.
     */

    public Node<T> getLink() {
        return link;
    }

    /**
     * Sets the reference to the next node linked to this node.
     *
     * @param link The next node to be linked to this node.
     */

    public void setLink(Node<T> link) {
        this.link = link;
    }

    /**
     * Returns a string representation of the data stored in this node.
     *
     * @return A string representation of the data.
     */

    @Override
    public String toString() {
        if (info == null) {
            return "null";
        }
        return info.toString();
    }
}
