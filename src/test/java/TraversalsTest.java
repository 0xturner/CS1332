
import org.junit.jupiter.api.*;

public class TraversalsTest {

  private Traversals<Integer> traversals;

  @BeforeAll
  public static void setupAll() {
    // System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup() {
    // System.out.println("Instantiating Contact Manager");
    traversals = new Traversals<Integer>();
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
