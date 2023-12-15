package Midterm.QueueDataStructureActivity;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**Name: ENCARNACION, Ma. Earl Freskkie
 * Date: October 18. 2023
 *
 * Algorithm:
 * Initialize randomArrivalGenerator and randomServiceTimeGenerator.
 * Initialize an empty queue myListOfClients.
 * Initialize nextArrivalTime as a random number between 0 and averageInterarrival.
 * Initialize clientId as 1.
 * Create a new server object server.
 * Simulation Loop (time from 0 to simulationTimeDuration):
 *
 * Check if a client arrives at time equals nextArrivalTime.
 * Create a new client with clientId and nextArrivalTime.
 * Add the client to myListOfClients.
 * Increment clientId.
 * Generate the next random arrival time for the next client.
 * Check if the server is idle and there are clients in the queue.
 * Serve the first client in the queue.
 * Set the server's start service time and stop service time.
 * Update nextArrivalTime.
 * Check if the server has finished serving a client at time.
 * Print the elements of the queue a.
 */

public class QueueSimulation {
    public static void main(String[] args) {
        QueueSimulation simulation;
        try {
            simulation = new QueueSimulation();
            simulation.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    public void run() {
        Random randomArrivalGenerator = new Random();
        Random randomServiceTimeGenerator = new Random();
        int averageInterarrival = 4;
        int simulationTimeDuration = 50; //length of simulation time
        double meanServiceTime = 5;

        //Generate random arrival of the first client
        int nextArrivalTime = randomArrivalGenerator.nextInt(averageInterarrival);

        //Create an ArrayList that will hold Queue of Clients
        Queue<Client> myListOfClients = new LinkedList<Client>();
        int clientId = 1;

        //Instantiate the server with no assigned client
        Server server = new Server();

        //Let simulation run from time =0 to a set length of time
        for (int time = 0; time <= simulationTimeDuration; time += 1) {

            //check if a client arrives
            if (time == nextArrivalTime) {
                System.out.println("Client " + clientId + " has arrived at time = " + nextArrivalTime + ".");
                // Construct a client object and add the client object to the Queue of waiting clients
                Client newClient = new Client(clientId, nextArrivalTime);
                myListOfClients.add(newClient);

                //Show the Queue of waiting clients and the number of waiting clients
                showList(myListOfClients);
                System.out.println("Number of clients in the list = " + myListOfClients.size());
                //Prepare the id of the next client that will arrive next
                clientId += 1;
                //Generate the random arrival time of the next client
                nextArrivalTime += 1 + randomArrivalGenerator.nextInt(averageInterarrival);
                System.out.println("\nNext client will arrive at time= " + nextArrivalTime);
            }

            // Check if the server is idle and if there is a client waiting to be served
            if (server.isIdle() && !myListOfClients.isEmpty()) {

                //Let the server start serving the first client in the Queue
                Client clientToServe = myListOfClients.remove();
                server.setClient(clientToServe);
                server.setStartServiceTime(time);

                //Generate the random length of time for the server to serve the client
                int serveTime = randomServiceTimeGenerator.nextInt((int) meanServiceTime);
                int timeForServerToBecomeFree = time + serveTime;
                server.setStopServiceTime(timeForServerToBecomeFree);
                System.out.println("At time= " + time + " Server started serving client " + clientToServe + ".");
                System.out.println("Server will be free at time = " + timeForServerToBecomeFree);

                //Show the updated Queue of waiting clients
                showList(myListOfClients);
            }

            //Check if the server is to finish serving a client
            if (time == server.getStopServiceTime() && time > 0) {
                System.out.println("At time = " + time + " Server finished serving client " + server.getClient() + ".");

                //Let the status of the server be idle
                server.setClient(null);
            }
        } //end of for
    } //end of run
    public void showList(Queue<Client> a) {
        System.out.print("Queue of Waiting Clients: ");
        for(Client c: a){
            System.out.print(c.toString() + " ");
        }
        System.out.println();
        return;
    }
}
