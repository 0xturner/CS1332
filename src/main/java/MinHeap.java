import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

  /**
   * The initial capacity of the MinHeap.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 13;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int size;

  /**
   * This is the constructor that constructs a new MinHeap.
   *
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast a Comparable[] to a T[] to get the generic typing.
   */
  public MinHeap() {
    // DO NOT MODIFY THIS METHOD!
    backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  private void doubleCapacity() {
    T[] newArray = (T[]) new Comparable[backingArray.length * 2];
    for (int i = 0; i < backingArray.length; i++) {
      newArray[i] = backingArray[i];
    }
    backingArray = newArray;
  }

  private void swap(int idx1, int idx2) {
    T value1 = backingArray[idx1];
    T value2 = backingArray[idx2];
    backingArray[idx2] = value1;
    backingArray[idx1] = value2;

  }

  private void rUpHeap(T data, int idx) {

    if (idx == 1) {
      return;
    }

    int parentIdx = idx / 2;
    T parent = backingArray[parentIdx];

    if (parent == null) {
      return;
    }

    // parent smaller than data
    if (parent.compareTo(data) < 0) {
      return;
    }

    swap(idx, parentIdx);
    rUpHeap(data, parentIdx);
  }

  /**
   * Adds an item to the heap. If the backing array is full (except for
   * index 0) and you're trying to add a new item, then double its capacity.
   *
   * Method should run in amortized O(log n) time.
   *
   * @param data The data to add.
   * @throws java.lang.IllegalArgumentException If the data is null.
   */
  public void add(T data) {

    if (data == null) {
      throw new IllegalArgumentException("Can't be null");
    }

    // if empty set index 0 to null
    if (size == 0) {
      size++;
    }

    if (size >= backingArray.length) {
      doubleCapacity();
    }

    // add to end
    backingArray[size] = data;
    size++;

    rUpHeap(data, size - 1);

    // to get parent -> index / 2 (round down)
  }

  private void rDownHeap(int idx) {

    // left child -> index * 2
    // right child -> index * 2 + 1

    // get comparison child
    // if two, get smaller
    // if none return

    // at the leaf node
    if (idx * 2 > size) {

      return;
    }

    T rightChild = backingArray[idx * 2 + 1];
    T leftChild = backingArray[idx * 2];
    T comparisonChild = leftChild;
    int comparisonIdx = idx * 2;

    if (rightChild != null && rightChild.compareTo(leftChild) < 0) {
      comparisonChild = rightChild;
      comparisonIdx = idx * 2 + 1;
    }

    // if data is smaller end
    if (backingArray[idx].compareTo(comparisonChild) < 0) {
      return;
    }

    swap(idx, comparisonIdx);
    rDownHeap(comparisonIdx);
  }

  /**
   * Removes and returns the min item of the heap. As usual for array-backed
   * structures, be sure to null out spots as you remove. Do not decrease the
   * capacity of the backing array.
   *
   * Method should run in O(log n) time.
   *
   * @return The data that was removed.
   * @throws java.util.NoSuchElementException If the heap is empty.
   */
  public T remove() {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

    T toRemove = backingArray[1];
    if (toRemove == null) {
      throw new NoSuchElementException("Heap is empty");
    }

    // move last element into root
    backingArray[1] = backingArray[size - 1];
    backingArray[size - 1] = null;
    size--;

    rDownHeap(1);
    // downheap:
    // compare both children, note smaller one
    // if one child(left), compare to that child
    // if no children return
    // compare data to child, swap if child smaller
    // repeat until, no swap or leaf is reached

    return toRemove;
  }

  /**
   * Returns the backing array of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The backing array of the list
   */
  public T[] getBackingArray() {
    // DO NOT MODIFY THIS METHOD!
    return backingArray;
  }

  /**
   * Returns the size of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The size of the list
   */
  public int size() {
    // DO NOT MODIFY THIS METHOD!
    return size;
  }
}