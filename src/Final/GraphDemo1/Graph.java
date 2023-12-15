package Final.GraphDemo1;
/**@author: ENCARNACION, Ma. Earl Freskkie A
 * @since: November 18, 2023*/

import java.util.ArrayList;
import java.util.List;

public class Graph {
    // Represents a graph composed of edges and nodes
    private List<Edge> nodes = new ArrayList<>();
    private int numberOfNodes = 0;

    // Checks if there are enough nodes in the graph for connectivity
    public boolean checkForAvailability() {
        return numberOfNodes > 1;
    }

    // Adds a node to the graph
    public void createNode(Edge node) {
        nodes.add(node);
        numberOfNodes++;
    }

    // Getter for the number of nodes in the graph
    public int getNumberOfNode() {
        return numberOfNodes;
    }
}
