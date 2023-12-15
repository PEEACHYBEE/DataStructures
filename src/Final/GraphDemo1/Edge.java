package Final.GraphDemo1;
/**@author: ENCARNACION, Ma. Earl Freskkie A
 * @since: November 18, 2023*/

import java.util.ArrayList;
import java.util.List;
// Represents an edge in the graph
public class Edge {
    private int id;
    private List<Node> neighbours = new ArrayList<>();

    // Constructor for Edge class
    public Edge(int id) {
        this.id = id;
    }

    // Getter for the edge's ID
    public int getNodeId() {
        return id;
    }

    // Adds a neighbor node to the edge
    public void addNeighbour(Node node) {
        if (neighbours.contains(node)) {
            System.out.println("This edge has already been used for this node.");
        } else {
            System.out.println("Successfully added " + node);
            neighbours.add(node);
        }
    }

    // Displays the list of neighbors for the edge
    public void getNeighbours() {
        System.out.println("List of all edges that node " + id + " has: ");
        System.out.println("=================================");
        for (Node neighbour : neighbours) {
            System.out.println("ID of Edge: " + neighbour.getId() +
                    "\nID of the first node: " + neighbour.getIdOfStartNode() +
                    "\nID of the second node: " + neighbour.getIdOfEndNode() + "\n");
        }
        System.out.println(neighbours);
    }

    // Overrides toString method to provide a string representation of the edge
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
