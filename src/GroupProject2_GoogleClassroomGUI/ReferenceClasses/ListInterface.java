package GroupProject2_GoogleClassroomGUI.ReferenceClasses;
/**
 * The `ListInterface` interface represents a generic list data structure.
 * It defines a set of common operations that can be performed on a list.
 *
 * @param <T> The type of elements stored in the list.
 */
public interface ListInterface<T> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element The element to be added to the list.
     */
    void add(T element);

    /**
     * Inserts an element at a specific index in the list.
     *
     * @param index   The index at which the element should be inserted.
     * @param element The element to be inserted into the list.
     */
    void insert(int index, T element);

    /**
     * Removes an element at a specific index from the list.
     *
     * @param index The index of the element to be removed.
     */
    void remove(int index);

    /**
     * Gets the size (number of elements) of the list.
     *
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Checks if the list is empty.
     *
     * @return `true` if the list is empty, `false` otherwise.
     */
    boolean isEmpty();

    /**
     * Gets an element at a specific index in the list.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    T get(int index);

    /**
     * Searches for an element in the list and returns its index.
     *
     * @param element The element to search for.
     * @return The index of the element if found, or -1 if not found.
     */
    int indexOf(T element);

    /**
     * Clears all elements from the list, making it empty.
     */
    void clear();

}
