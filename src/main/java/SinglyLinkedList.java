import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private SinglyLinkedListNode<T> head;
  private SinglyLinkedListNode<T> tail;
  private int size;

  /*
   * Do not add a constructor.
   */

  /**
   * Adds the element to the front of the list.
   *
   * Method should run in O(1) time.
   *
   * @param data the data to add to the front of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToFront(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Can't be null");
    }

    // empty
    if (head == null) {
      SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
      head = temp;
      tail = temp;
      size = 1;
      return;
    }

    SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data, head);
    head = temp;
    size++;
  }

  /**
   * Adds the element to the back of the list.
   *
   * Method should run in O(1) time.
   *
   * @param data the data to add to the back of the list
   * @throws java.lang.IllegalArgumentException if data is null
   */
  public void addToBack(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Can't be null");
    }

    // empty
    if (head == null) {
      SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
      head = temp;
      tail = temp;
      size = 1;
      return;
    }

    SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
    tail.setNext(temp);
    tail = temp;
    size++;
  }

  /**
   * Adds the element to the specified index.
   *
   * Must be O(1) for indices 0 and size and O(n) for all other cases.
   *
   * ASSUMPTIONS:
   * - You may assume that the index will always be valid [0, size]
   * - You may assume that the data will not be null
   *
   * @param index the index to add the new element
   * @param data  the data to add
   */
  public void addAtIndex(int index, T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

    // empty
    if (head == null) {
      SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
      head = temp;
      tail = temp;
      size = 1;
      return;
    }

    if (index == 0) {
      SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data, head);
      head = temp;
      size++;
      return;
    }

    if (index == size) {
      SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
      tail.setNext(temp);
      tail = temp;
      size++;
      return;
    }

    // start at head and iterate until index -1 is reached
    // create new node with next = next
    // change current next to new node

    SinglyLinkedListNode<T> curr = head;

    int i = 0;
    while (i < index) {
      if (i + 1 == index) {
        SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data, curr.getNext());
        curr.setNext(temp);
        size++;
        i++;
        return;
      }
      curr = curr.getNext();
      i++;
    }
  }

  /**
   * Removes and returns the first data of the list.
   *
   * Method should run in O(1) time.
   *
   * @return the data formerly located at the front of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    SinglyLinkedListNode<T> oldHead = head;

    // ! In case failing, might have to remove prev head next pointer, probably
    // ! garbage collected though
    if (head.getNext() == null) {
      head = null;
      tail = null;
    } else {
      head = head.getNext();
    }

    size--;
    return oldHead.getData();
  }

  /**
   * Removes and returns the last data of the list.
   *
   * Method should run in O(n) time.
   *
   * @return the data formerly located at the back of the list
   * @throws java.util.NoSuchElementException if the list is empty
   */
  public T removeFromBack() {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }
    SinglyLinkedListNode<T> oldTail = tail;

    if (head.getNext() == null) {
      head = null;
      tail = null;
    } else {
      SinglyLinkedListNode<T> curr = head;

      // while next is not the tail
      while (curr.getNext().getNext() != null) {
        curr = curr.getNext();
      }
      curr.setNext(null);
      tail = curr;
    }

    size--;
    return oldTail.getData();
  }

  /**
   * Returns the head node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the head of the list
   */
  public SinglyLinkedListNode<T> getHead() {
    // DO NOT MODIFY THIS METHOD!
    return head;
  }

  /**
   * Returns the tail node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the tail of the list
   */
  public SinglyLinkedListNode<T> getTail() {
    // DO NOT MODIFY THIS METHOD!
    return tail;
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