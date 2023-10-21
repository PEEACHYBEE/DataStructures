package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 7, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<E> implements MyList<E> {

    public Object[] array; //Array to store the elements. Using Object to handle generic data
    private int count; //Number of elements added to the array

    /**Constructor initializes the array and sets the count to zero*/
    public MyFixedSizeArrayList() {
        array = new Object[5];
        count = 0;
    }

    /**Adds an item to the array*/
    @Override
    public void insert(E data) throws ListOverflowException {
        if (count == 5) {
            throw new ListOverflowException("LIST IS FULL=====");
        }
        array[count++] = data;
    }

    /**Fetches an item from the array at the given index*/
    @Override
    public E getElement(E data) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(data)) {
                return (E) array[i];
            }
        }
        throw new NoSuchElementException("Data NOT FOUND in the list");
    }

    @Override
    public boolean delete(E data) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < count - 1; j++) {
                    array[j] = array[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int search(E data) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    /**Return the number of elements in the array*/
    @Override
    public int getSize() {
        return count;
    }

    public static class ListOverflowException extends Exception {
        public ListOverflowException(String message) {
            super(message);
        }
    }
}
