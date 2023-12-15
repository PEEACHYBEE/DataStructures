package Final.HashTable;
/**
 * @author: ENCARNACION, Ma. Earl Freskkie
 * @since: December 4, 2023
 * */

/**The Person class represents a person with a name and age, implementing the Comparable interface.*/
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    /** Default constructor initializes name to an empty string and age to 0.*/
    public Person() {
        name = "";
        age = 0;
    }

    /**
     * Parameterized constructor creates a Person object with the specified name and age.
     * @param n The name of the person.
     * @param a The age of the person.
     */
    public Person(String n, int a) {
        name = n;
        age = a;
    }

    /**
     * Sets the name of the person.
     * @param n The new name to set.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Sets the age of the person.
     * @param a The new age to set.
     */
    public void setAge(int a) {
        age = a;
    }

    /**
     * Retrieves the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the age of the person.
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string representation of the Person object.
     * @return A string representation in the format: "(name, age)".
     */
    public String toString() {
        return "(" + name + "," + age + ")";
    }

    /**
     * Checks if the current Person object is equal to another Person object.
     * @param other The other Person object to compare.
     * @return True if the two objects are equal, false otherwise.
     */
    public boolean equals(Person other) {
        return toString().equals(((Person) other).toString());
    }

    /**
     * Compares the current Person object with another Person object.
     * @param another The other Person object to compare.
     * @return A negative integer if the current object is less than the other,
     *         zero if they are equal, and a positive integer if the current object is greater.
     */
    public int compareTo(Person another) {
        return toString().compareTo(another.toString());
    }
}