package Final.GraphDemo1;
/**@author: ENCARNACION, Ma. Earl Freskkie A
 * @since: November 18, 2023*/

public class TestGraph {
    // Test class for the graph implementation
    public static void main(String[] args) {
        Graph graph = new Graph();

        Edge node1 = new Edge(1);
        Edge node2 = new Edge(2);
        Edge node3 = new Edge(3);

        graph.createNode(node1);
        graph.createNode(node2);
        graph.createNode(node3);

        Node e12 = new Node(node1, node2, 5, 1);
        Node e13 = new Node(node1, node3, 10, 2);

        if (graph.checkForAvailability()) {
            node1.addNeighbour(e12);
            node1.addNeighbour(e13);
            node1.getNeighbours();
        } else {
            System.out.println("There are less than 2 nodes. Add more to connect.");
        }
    }
}
