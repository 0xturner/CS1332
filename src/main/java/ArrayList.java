import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    private void doubleCapacity() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Can't be null");
        }
        int newLength = size >= backingArray.length ? backingArray.length * 2 : backingArray.length;
        T[] newArray = (T[]) new Object[newLength];

        newArray[0] = data;
        for (int i = 1; i <= size; i++) {
            newArray[i] = backingArray[i - 1];
        }
        backingArray = newArray;
        size++;
    }

    // IMPORTANT this method does not do resizing
    public void addAtIndex(int index, T data) {
        T[] newArray = (T[]) new Object[backingArray.length];

        for (int i = 0; i <= size; i++) {
            if (i < index) {
                newArray[i] = backingArray[i];
            } else if (i == index) {
                newArray[i] = data;
            } else {
                newArray[i] = backingArray[i - 1];
            }
        }
        size++;
        backingArray = newArray;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Can't be null");
        }

        if (size >= backingArray.length) {
            doubleCapacity();
        }
        backingArray[size] = data;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (backingArray[0] == null) {
            throw new NoSuchElementException("List is empty");
        }

        T[] newArray = (T[]) new Object[backingArray.length];

        T firstElement = backingArray[0];

        for (int i = 0; i < size - 1; i++) {
            newArray[i] = backingArray[i + 1];
        }

        backingArray = newArray;
        size--;
        return firstElement;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (backingArray[0] == null) {
            throw new NoSuchElementException("List is empty");
        }

        T lastElement = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return lastElement;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}