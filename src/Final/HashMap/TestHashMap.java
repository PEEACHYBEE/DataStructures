package Final.HashMap;

/**
 * Algorithm:
 * This program demonstrates the use of different implementations of the Map interface
 * (HashMap, TreeMap, and LinkedHashMap) in Java.
 * It creates a HashMap, converts it to a TreeMap, and uses a LinkedHashMap.
 * The HashMap is initially populated with name-age pairs, and the entries are displayed.
 * The program then creates a TreeMap from the HashMap and displays the entries in ascending order of keys.
 * Finally, a LinkedHashMap is used to store name-age pairs with a specific order and access order.
 * The age of a specific person ("Lewis") is retrieved and displayed, and the LinkedHashMap entries are displayed.
 *
 * @author: ENCARNACION, Ma. Earl Freskkie
 * @since: December 6, 2023
 * */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMap {
    /**
     * The main method demonstrates the use of HashMap, TreeMap, and LinkedHashMap.
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        // Create a TreeMap from the previous HashMap
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        // Create a LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16, 0.75f, true);

        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        //Display the age for Lewis
        System.out.println("The age for " + "Lewis is " + linkedHashMap.get("Lewis").intValue());

        System.out.println("\n Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

    }
}
