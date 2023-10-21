package LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 6, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
import java.util.NoSuchElementException;

public interface MyList <E> {
    public int getSize();
    public void insert(E data) throws ListOverflowException, MyFixedSizeArrayList.ListOverflowException;
    public E getElement(E data) throws NoSuchElementException;
    public boolean delete(E data); // returns false if the data is not deleted in the list
    public int search(E data); // returns index of data, else -1 is return
}
