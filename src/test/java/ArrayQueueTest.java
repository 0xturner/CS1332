
// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.*;

public class ArrayQueueTest {

  private ArrayQueue<Integer> arrayQueue;

  @BeforeAll
  public static void setupAll() {
    // System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup() {
    arrayQueue = new ArrayQueue<Integer>();
  }

  @Test
  @DisplayName("Enqueue empty")
  public void enqueueEmpty() {
    arrayQueue.enqueue(1);
    arrayQueue.enqueue(2);
    arrayQueue.enqueue(3);

    Integer[] expected = { 1, 2, 3, null, null, null, null, null, null };
    String stringifiedExpected = Arrays.toString(expected);

    assertEquals(3, arrayQueue.size());
    assertEquals(stringifiedExpected, Arrays.toString(arrayQueue.getBackingArray()));
  }

  @Test
  @DisplayName("Enqueue then dequeue")
  public void enqueueDequeue() {
    arrayQueue.enqueue(1);
    arrayQueue.enqueue(2);
    arrayQueue.enqueue(3);

    Integer popped1 = arrayQueue.dequeue();
    Integer popped2 = arrayQueue.dequeue();

    Integer[] expected = { null, null, 3, null, null, null, null, null, null };
    String stringifiedExpected = Arrays.toString(expected);

    assertEquals(1, arrayQueue.size());
    assertEquals(1, arrayQueue.size());
    assertEquals(1, popped1);
    assertEquals(2, popped2);
    assertEquals(stringifiedExpected, Arrays.toString(arrayQueue.getBackingArray()));
  }

  @Test
  @DisplayName("WrapAround")
  public void wrapAround() {
    arrayQueue.enqueue(1);
    arrayQueue.enqueue(2);
    arrayQueue.enqueue(3);
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.enqueue(4);
    arrayQueue.enqueue(5);
    arrayQueue.enqueue(6);
    arrayQueue.enqueue(7);
    arrayQueue.enqueue(8);
    arrayQueue.enqueue(9);
    arrayQueue.enqueue(10);
    arrayQueue.enqueue(11);

    Integer[] expected = { 10, 11, 3, 4, 5, 6, 7, 8, 9 };
    String stringifiedExpected = Arrays.toString(expected);

    assertEquals(9, arrayQueue.size());
    assertEquals(stringifiedExpected, Arrays.toString(arrayQueue.getBackingArray()));
  }

  @Test
  @DisplayName("Resize")
  public void resize() {
    arrayQueue.enqueue(1);
    arrayQueue.enqueue(2);
    arrayQueue.enqueue(3);
    arrayQueue.dequeue();
    arrayQueue.enqueue(4);
    arrayQueue.enqueue(5);
    arrayQueue.enqueue(6);
    arrayQueue.enqueue(7);
    arrayQueue.enqueue(8);
    arrayQueue.enqueue(9);
    arrayQueue.enqueue(10);
    arrayQueue.dequeue();
    arrayQueue.enqueue(11);
    arrayQueue.enqueue(12);
    arrayQueue.dequeue();
    arrayQueue.enqueue(13);

    String stringifiedArray = Arrays.toString(arrayQueue.getBackingArray());
    System.out.println(stringifiedArray);

    assertEquals(10, arrayQueue.size());
  }

  @Test
  @DisplayName("dequeueFrontAtBack")
  public void dequeueFrontAtBack() {
    arrayQueue.enqueue(1);
    arrayQueue.enqueue(2);
    arrayQueue.enqueue(3);
    arrayQueue.enqueue(4);
    arrayQueue.enqueue(5);
    arrayQueue.enqueue(6);
    arrayQueue.enqueue(7);
    arrayQueue.enqueue(8);
    arrayQueue.enqueue(9);
    // arrayQueue.enqueue(10);
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.enqueue(10);
    arrayQueue.dequeue();

    String stringifiedArray = Arrays.toString(arrayQueue.getBackingArray());
    System.out.println(stringifiedArray);

    // assertEquals(10, arrayQueue.size());

    // Integer[] expected = { 10, 11, 3, 4, 5, 6, 7, 8, 9 };
    // String stringifiedExpected = Arrays.toString(expected);

    // assertEquals(9, arrayQueue.size());
    // assertEquals(stringifiedExpected,
    // Arrays.toString(arrayQueue.getBackingArray()));
  }

  // tod dequeue everything

}
