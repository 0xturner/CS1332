
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

public class BSTTest {

  private BST<Integer> tree;

  @BeforeAll
  public static void setupAll() {
  }

  @BeforeEach
  public void setup() {
    tree = new BST<Integer>();
    tree.add(50);
    tree.add(15);
    tree.add(5);
    tree.add(10);
    tree.add(75);
    tree.add(100);
  }

  @Test
  @DisplayName("add")
  public void add() {
    tree.add(25);
    assertEquals(25, tree.getRoot().getLeft().getRight().getData());
    assertEquals(10, tree.getRoot().getLeft().getLeft().getRight().getData());
    assertEquals(100, tree.getRoot().getRight().getRight().getData());
  }

  @Test
  @DisplayName("remove leaf child")
  public void removeLeaf() {
    int result = tree.remove(10);
    assertEquals(10, result);

    System.out.println(tree.getRoot().getData());

  }

  @Test
  @DisplayName("remove one child")
  public void removeOne() {
    int result = tree.remove(5);
    assertEquals(5, result);

  }

  @Test
  @DisplayName("remove two child")
  public void removeTwo() {
    int result = tree.remove(50);
    assertEquals(50, result);
    assertEquals(75, tree.getRoot().getData());
  }

  @Test
  @DisplayName("remove doesn't exist")
  public void removeNone() {
    Assertions.assertThrows(NoSuchElementException.class, () -> {
      tree.remove(99);
    });
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
