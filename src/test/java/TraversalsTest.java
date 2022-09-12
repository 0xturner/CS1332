
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class TraversalsTest {

  private Traversals<Integer> traversals;
  private TreeNode<Integer> root;

  @BeforeAll
  public static void setupAll() {
    // System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup() {
    // System.out.println("Instantiating Contact Manager");
    traversals = new Traversals<Integer>();
    root = new TreeNode<Integer>(50);
    TreeNode<Integer> twentyFive = new TreeNode<>(25);
    TreeNode<Integer> ten = new TreeNode<>(10);
    TreeNode<Integer> hundred = new TreeNode<>(100);
    TreeNode<Integer> seventyFive = new TreeNode<>(75);
    TreeNode<Integer> oneTwentyFive = new TreeNode<>(125);
    TreeNode<Integer> oneTen = new TreeNode<>(110);

    root.setLeft(twentyFive);
    twentyFive.setLeft(ten);
    root.setRight(hundred);
    hundred.setLeft(seventyFive);
    hundred.setRight(oneTwentyFive);
    oneTwentyFive.setLeft(oneTen);

    System.out.println(root.getRight().getRight().getLeft().getData());

  }

  @Test
  @DisplayName("preorder")
  public void preorder() {
    List<Integer> order = traversals.preorder(root);
    assertEquals("[50, 25, 10, 100, 75, 125, 110]", order.toString());
  }

  @Test
  @DisplayName("inorder")
  public void inorder() {
    List<Integer> order = traversals.inorder(root);
    System.out.println(order.toString());
    assertEquals("[10, 25, 50, 75, 100, 110, 125]", order.toString());
  }

  @Test
  @DisplayName("postOrder")
  public void postorder() {
    List<Integer> order = traversals.postorder(root);
    System.out.println(order.toString());
    assertEquals("[10, 25, 75, 110, 125, 100, 50]", order.toString());
  }

  // test null case

  @AfterEach
  public void tearDown() {
    // System.out.println("Should Execute After Each Test");
  }

  @AfterAll
  public static void tearDownAll() {
    // System.out.println("Should be executed at the end of the Test");
  }
}
