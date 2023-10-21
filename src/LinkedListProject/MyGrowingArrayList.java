package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 12, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
import java.util.NoSuchElementException;

public class MyGrowingArrayList <E> implements MyList<E>{
    public Object[] array; // Array to store the elements. Using Object to handle generic data.
    private int count; // Tracks the number of elements added to the array.

    /**Default constructor initializes the array with a size of 5. */
    public MyGrowingArrayList(){
        array = new Object[5]; // initial size
        count = 0;
    }

    @Override
    public void insert(E data){ // Check if the array is full
        if (count == array.length){
            Object[] newArray = new Object[array.length * 2]; // Double the array size
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[count++] = data;
    }

    @Override
    public E getElement(E data) throws NoSuchElementException{
        for (int i = 0; i < count; i++) { // Search the element in the array.
            if (array[i].equals(data)) {
                return (E) array[i];
            }
        }
        throw new NoSuchElementException("Data NOT FOUND in the list=====");  // If not found, throw exception.
    }

    @Override
    public boolean delete(E data){ // Search the element to delete.
        for (int i = 0; i < count; i++){
            if (array[i].equals(data)){
                System.arraycopy(array, i + 1, array, i, count - i - 1);
                count--;
                return true;
            }
        }
        return false; // Returns false if data is not found.
    }

    @Override
    public int search(E data){  // Search the element and return its index.
        for (int i = 0; i < count; i++){
            if (array[i].equals(data)){
                return i;
            }
        }
        return -1; // Return -1 if not found.
    }

    @Override
    public int getSize(){
        return count;
    }
}
