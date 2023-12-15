package Final.GraphDemo1;
/**@author: ENCARNACION, Ma. Earl Freskkie A
 * @since: November 18, 2023*/

// Represents a node in the graph with start and end edges
public class Node {
    private Edge start;
    private Edge end;
    private double weight;
    private int id;

    // Constructor for the Node class
    public Node(Edge start, Edge end, double weight, int id) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.id = id;
    }

    // Getter for the node's ID
    public int getId() {
        return id;
    }

    // Getter for the starting edge of the node
    public Edge getStart() {
        return start;
    }

    // Getter for the ID of the starting node
    public int getIdOfStartNode() {
        return start.getNodeId();
    }

    // Getter for the ending edge of the node
    public Edge getEnd() {
        return end;
    }

    // Getter for the ID of the ending node
    public int getIdOfEndNode() {
        return end.getNodeId();
    }

    // Getter for the weight of the node
    public double getWeight() {
        return weight;
    }

    // Overrides toString method to provide a string representation of the node
    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
