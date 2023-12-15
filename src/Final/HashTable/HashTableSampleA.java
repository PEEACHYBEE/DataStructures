package Final.HashTable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
/**
 * @author: ENCARNACION, Ma. Earl Freskkie
 * @since: December 4, 2023
 */
/**This class demonstrates the usage of Hashtable in Java and includes a variety of operations*/
public class HashTableSampleA {

    /**
     * Prints the elements in the given iterator.
     * @param iterator The iterator containing elements to be printed.
     */
    public static void print(Iterator iterator) {
        if (iterator.hasNext()) {
            System.out.print(iterator.next());
            while (iterator.hasNext()) {
                System.out.print("," + iterator.next());
            }
        }
    }

    /**
     * The main method demonstrating the usage of Hashtable and related operations.
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Creating a Hashtable with Integer keys and Person values
        Hashtable<Integer, Person> hashTable1 = new Hashtable<>(4);

        // Adding elements to the Hashtable
        hashTable1.put("Lord".hashCode(), new Person("Lord", 18));
        hashTable1.put("Kathleen".hashCode(), new Person("Kathleen", 17));
        System.out.println(hashTable1);

        hashTable1.put("Gracie".hashCode(), new Person("Gracie", 20));
        System.out.println(hashTable1);

        // Printing elements using the print method
        print(hashTable1.entrySet().iterator());
        print(hashTable1.keySet().iterator());
        print((Iterator) hashTable1.elements());

        System.out.println("");

        // Searching for an element in the Hashtable
        System.out.print("\nEnter a name to search: ");
        String searchKey = keyboard.nextLine();
        System.out.println(hashTable1.get(searchKey.hashCode()));
    }
}
