
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class BSTTest {

  @BeforeAll
  public static void setupAll() {
  }

  @BeforeEach
  public void setup() {

  }

  @Test
  @DisplayName("add")
  public void add() {
    BST<Integer> tree = new BST<Integer>();
    tree.add(50);
    tree.add(15);
    tree.add(5);
    tree.add(10);
    tree.add(75);
    tree.add(100);
    tree.add(25);

    assertEquals(25, tree.getRoot().getLeft().getRight().getData());
    assertEquals(10, tree.getRoot().getLeft().getLeft().getRight().getData());
    assertEquals(100, tree.getRoot().getRight().getRight().getData());
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
