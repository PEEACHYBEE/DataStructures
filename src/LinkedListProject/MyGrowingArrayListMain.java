package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 12, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyGrowingArrayListMain {
    public static void main(String[] args){
        // List to store the user's cars.
        MyGrowingArrayList<String> cars = new MyGrowingArrayList<>();
        Scanner kbd = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop){
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a car");
            System.out.println("2. View cars");
            System.out.println("3. Search for a car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = kbd.nextInt();
            kbd.nextLine();

            switch (choice){
                case 1:
                    // Add a car to the list.
                    System.out.print("\nEnter your favorite car: ");
                    String car = kbd.nextLine();
                    cars.insert(car);
                    System.out.println("Car added successfully.");
                    break;
                case 2:
                    //Display all the cars
                    System.out.println("\nYour cars:");
                    for (int i = 0; i < cars.getSize(); i++){
                        try {
                            System.out.println((i + 1) + ". " + cars.getElement((String) cars.array[i]));
                        } catch (NoSuchElementException e) {
                            System.out.println("=====CAR NOT FOUND!: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    // Search for a specific car in the list.
                    System.out.print("\nEnter car brand to search: ");
                    String searchCar = kbd.nextLine();
                    int index = cars.search(searchCar);
                    if (index != -1) {
                        System.out.println("Car found at position: " + (index + 1));
                    } else {
                        System.out.println("=====CAR NOT FOUND=====");
                    }
                    break;
                case 4:
                    // Exit the program.
                    continueLoop = false;
                    System.out.println("Thank you for using the program :)");
                    break;
                default:
                    System.out.println("INVALID CHOICE. Please try again.");
            }
        }
        kbd.close();
    }
}
