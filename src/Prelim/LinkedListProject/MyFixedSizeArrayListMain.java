package Prelim.LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 9, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyFixedSizeArrayListMain {
    public static void main(String[] args){
        MyFixedSizeArrayList<String> cars = new MyFixedSizeArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("\nAdd your favorite car");
            System.out.println("1. Add a car");
            System.out.println("2. View your cars");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("\nEnter your car brand: ");
                    String brand = scanner.nextLine();
                    //Attempt to add the car
                    try {
                        cars.insert(brand);
                        System.out.println("\nYour car added successfully.");
                    } catch (MyFixedSizeArrayList.ListOverflowException e){
                        System.out.println("=====ERROR! " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\nYour favorite cars are:");
                    //Display the cars
                    for (int c = 0; c < cars.getSize(); c++){
                        try {
                            System.out.println((c + 1) + ". " + cars.getElement((String) cars.array[c]));
                        } catch (NoSuchElementException e){
                            System.out.println("NO PROPERTY FOUND! " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    loop = false;
                    System.out.println("\nThank you for using the program :)");
                    break;
                default:
                    System.out.println("\n=====INVALID CHOICE. Please try again.=====");
            }
        }
        scanner.close();
    }
}
