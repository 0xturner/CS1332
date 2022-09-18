
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import java.util.Arrays;
import org.junit.jupiter.api.*;

public class MinHeapTest {

  private MinHeap<Integer> minHeap;

  @BeforeAll
  public static void setupAll() {
  }

  @BeforeEach
  public void setup() {

  }

  @Test
  @DisplayName("add")
  public void add() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(1);
    minHeap.add(2);
    minHeap.add(3);
    minHeap.add(4);
    minHeap.add(5);
    minHeap.add(6);
    minHeap.add(7);
    minHeap.add(8);
    minHeap.add(9);
    minHeap.add(0);
    assertEquals("[null, 0, 1, 3, 4, 2, 6, 7, 8, 9, 5, null, null]", Arrays.toString(minHeap.getBackingArray()));
  }

  @Test
  @DisplayName("removeEmpty")
  public void removeEmpty() {
    minHeap = new MinHeap<Integer>();
    Assertions.assertThrows(NoSuchElementException.class, () -> {
      minHeap.remove();
    });
  }

  @Test
  @DisplayName("remove")
  public void remove() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(0);
    minHeap.add(1);
    minHeap.add(2);
    minHeap.add(3);
    minHeap.add(4);
    minHeap.add(5);
    minHeap.add(6);
    minHeap.add(7);
    minHeap.add(8);
    minHeap.add(9);
    minHeap.add(10);

    minHeap.remove();

  }

  @AfterEach
  public void tearDown() {
    // System.out.println("Should Execute After Each Test");
  }

  @AfterAll
  public static void tearDownAll() {
    // System.out.println("Should be executed at the end of the Test");
  }
}
