
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
    assertEquals("[null, 1, 2, 3, 4, 5, 6, 7, 8, 9, null, null, null]", Arrays.toString(minHeap.getBackingArray()));
    minHeap.add(0);
    assertEquals("[null, 0, 1, 3, 4, 2, 6, 7, 8, 9, 5, null, null]", Arrays.toString(minHeap.getBackingArray()));
  }

  @Test
  @DisplayName("add2")
  public void add2() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(0);
    minHeap.add(7);
    assertEquals("[null, 0, 7, null, null, null, null, null, null, null, null, null, null]",
        Arrays.toString(minHeap.getBackingArray()));
  }

  @Test
  @DisplayName("add3")
  public void add3() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(0);
    minHeap.add(7);
    minHeap.add(14);
    minHeap.add(21);
    minHeap.add(28);
    minHeap.add(35);
    minHeap.add(42);

    System.out.println(Arrays.toString(minHeap.getBackingArray()));
    assertEquals("[null, 0, 7, 14, 21, 28, 35, 42, null, null, null, null, null]",
        Arrays.toString(minHeap.getBackingArray()));

  }

  @Test
  @DisplayName("add4")
  public void add4() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(7);
    minHeap.add(14);
    minHeap.add(21);
    minHeap.add(28);
    minHeap.add(35);
    minHeap.add(42);
    minHeap.add(49);
    minHeap.add(56);
    minHeap.add(63);
    assertEquals("[null, 7, 14, 21, 28, 35, 42, 49, 56, 63, null, null, null]",
        Arrays.toString(minHeap.getBackingArray()));

    minHeap.add(0);

    System.out.println(Arrays.toString(minHeap.getBackingArray()));

    assertEquals("[null, 0, 7, 21, 28, 14, 42, 49, 56, 63, 35, null, null]",
        Arrays.toString(minHeap.getBackingArray()));
  }

  @Test
  @DisplayName("add resize")
  public void addResize() {
    minHeap = new MinHeap<Integer>();
    minHeap.add(0);
    minHeap.add(7);
    minHeap.add(14);
    minHeap.add(21);
    minHeap.add(28);
    minHeap.add(35);
    minHeap.add(42);
    minHeap.add(49);
    minHeap.add(56);
    minHeap.add(63);
    minHeap.add(70);
    minHeap.add(77);

    assertEquals("[null, 0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77]",
        Arrays.toString(minHeap.getBackingArray()));

    minHeap.add(84);
    assertEquals(
        "[null, 0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, null, null, null, null, null, null, null, null, null, null, null, null]",
        Arrays.toString(minHeap.getBackingArray()));

  }

  @Test
  @DisplayName("add null")
  public void addNull() {
    minHeap = new MinHeap<Integer>();
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      minHeap.add(null);
    });
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
    minHeap.add(4);
    minHeap.add(3);
    minHeap.add(5);
    minHeap.add(7);
    minHeap.add(6);
    minHeap.add(8);
    minHeap.add(9);
    minHeap.add(10);

    assertEquals(
        "[null, 0, 1, 2, 4, 3, 5, 7, 6, 8, 9, 10, null]",
        Arrays.toString(minHeap.getBackingArray()));

    minHeap.remove();

    assertEquals(
        "[null, 1, 3, 2, 4, 9, 5, 7, 6, 8, 10, null, null]",
        Arrays.toString(minHeap.getBackingArray()));

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
