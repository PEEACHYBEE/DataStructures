package Prelim.LinkedListProject;
/**Name: Encarnacion, Ma. Earl Freskkie A
 * Programming Date: September 7, 2023
 * Course Code and Schedule: 9449 IT212 3:00 - 4:30WS
 * Activity: Individual Project 1
 * */
public class LinkedListNodeEncarnacionMaEarlFreskkie <T>{
    private T data;
    private LinkedListNodeEncarnacionMaEarlFreskkie<T> next;
    private LinkedListNodeEncarnacionMaEarlFreskkie<T> prev;

    public LinkedListNodeEncarnacionMaEarlFreskkie(T data) {
        this.data = data;
        this.next = this;  // Initializes pointing to itself to form a cycle.
        this.prev = this;  // Same, pointing to itself initially.
    }

    public T getData() {
        return data;
    }

    public void setNext(LinkedListNodeEncarnacionMaEarlFreskkie<T> node) {
        this.next = node;
    }

    public LinkedListNodeEncarnacionMaEarlFreskkie<T> getNext() {
        return next;
    }

    public void setPrev(LinkedListNodeEncarnacionMaEarlFreskkie<T> node) {
        this.prev = node;
    }

    public LinkedListNodeEncarnacionMaEarlFreskkie<T> getPrev() {
        return prev;
    }
}
