import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

public class SinglyLinkedListTest {

  private SinglyLinkedList<Integer> singlyLinkedList;

  @BeforeAll
  public static void setupAll() {
    System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup() {
    System.out.println("Instantiating Contact Manager");
    singlyLinkedList = new SinglyLinkedList<Integer>();
  }

  @AfterEach
  public void tearDown() {
    System.out.println("Should Execute After Each Test");
  }

  @AfterAll
  public static void tearDownAll() {
    System.out.println("Should be executed at the end of the Test");
  }
}
