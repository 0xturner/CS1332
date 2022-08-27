import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class SinglyLinkedListTest {

  private SinglyLinkedList<Integer> singlyLinkedList;

  @BeforeAll
  public static void setupAll() {
    // System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup() {
    singlyLinkedList = new SinglyLinkedList<Integer>();
  }

  @Test
  @DisplayName("Should addToFront")
  public void addToFront() {
    singlyLinkedList.addToFront(1);
    singlyLinkedList.addToFront(2);

    assertEquals(2, singlyLinkedList.getHead().getData());
    assertEquals(1, singlyLinkedList.getHead().getNext().getData());
    assertEquals(1, singlyLinkedList.getTail().getData());
    assertEquals(null, singlyLinkedList.getTail().getNext());
    assertEquals(2, singlyLinkedList.size());
  }

  @Test
  @DisplayName("Should addToBack")
  public void addToBack() {
    singlyLinkedList.addToBack(1);
    singlyLinkedList.addToBack(2);

    assertEquals(1, singlyLinkedList.getHead().getData());
    assertEquals(2, singlyLinkedList.getHead().getNext().getData());
    assertEquals(2, singlyLinkedList.getTail().getData());
    assertEquals(null, singlyLinkedList.getTail().getNext());
    assertEquals(2, singlyLinkedList.size());
  }

  @Test
  @DisplayName("Should removeFromFront")
  public void removeFromFront() {
    singlyLinkedList.addToBack(1);
    singlyLinkedList.addToBack(2);

    Integer rm1 = singlyLinkedList.removeFromFront();

    assertEquals(1, rm1);
    assertEquals(2, singlyLinkedList.getHead().getData());
    assertEquals(null, singlyLinkedList.getHead().getNext());
    assertEquals(null, singlyLinkedList.getTail().getNext());
    assertEquals(1, singlyLinkedList.size());

    Integer rm2 = singlyLinkedList.removeFromFront();

    assertEquals(2, rm2);
    assertEquals(null, singlyLinkedList.getHead());
    assertEquals(null, singlyLinkedList.getTail());
    assertEquals(0, singlyLinkedList.size());

  }

  @Test
  @DisplayName("Should removeFromFront")
  public void removeFromBack() {
    singlyLinkedList.addToBack(1);
    singlyLinkedList.addToBack(2);
    singlyLinkedList.addToBack(3);

    Integer rm1 = singlyLinkedList.removeFromBack();

    assertEquals(3, rm1);
    assertEquals(1, singlyLinkedList.getHead().getData());
    assertEquals(2, singlyLinkedList.getHead().getNext().getData());
    assertEquals(2, singlyLinkedList.getTail().getData());
    assertEquals(null, singlyLinkedList.getTail().getNext());
    assertEquals(2, singlyLinkedList.size());

    Integer rm2 = singlyLinkedList.removeFromBack();

    assertEquals(2, rm2);
    assertEquals(null, singlyLinkedList.getHead().getNext());
    assertEquals(1, singlyLinkedList.getTail().getData());
    assertEquals(null, singlyLinkedList.getTail().getNext());
    assertEquals(1, singlyLinkedList.size());

    Integer rm3 = singlyLinkedList.removeFromBack();

    assertEquals(1, rm3);
    assertEquals(null, singlyLinkedList.getHead());
    assertEquals(null, singlyLinkedList.getTail());
    assertEquals(0, singlyLinkedList.size());

  }

}
