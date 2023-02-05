import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import java.util.Arrays;
import org.junit.jupiter.api.*;

public class ExternalChainingHashMapTest {

  //  private ExternalChainingMapEntry<Integer, Integer> entry;
  private ExternalChainingHashMap<Integer, Integer> map;


  @BeforeAll
  public static void setupAll() {
  }

  @BeforeEach
  public void setup() {

  }

  @Test
  @DisplayName("put no collision")
  public void putNoCollision() {
    map = new ExternalChainingHashMap<Integer, Integer>();
    map.put(5, 5);
    assertEquals("[null, null, null, null, null, (5, 5), null, null, null, null, null, null, null]", Arrays.toString(map.getTable()));
    assertEquals(map.size(), 1);
  }

  @Test
  @DisplayName("put collision")
  public void putCollision() {
    map = new ExternalChainingHashMap<Integer, Integer>();
    map.put(19, 19);
    map.put(8, 8);
    map.put(11, 11);
    map.put(25, 25);
    map.put(6, 6);
    map.put(32, 32);
    assertEquals("[null, null, null, null, null, null, (32, 32), null, (8, 8), null, null, (11, 11), (25, 25)]", Arrays.toString(map.getTable()));

    ExternalChainingMapEntry node = map.getTable()[6];
    assertEquals(node.getValue(), 32);
    assertEquals(node.getNext().getValue(), 6);
    assertEquals(node.getNext().getNext().getValue(), 19);
  }

  @Test
  @DisplayName("put collision and duplicate")
  public void putCollisionAndDupe() {
    map = new ExternalChainingHashMap<Integer, Integer>();
    map.put(6, 6);
    map.put(19, 19);
    map.put(8, 8);
    map.put(37, 37);
    map.put(24, 23);
    map.put(11, 11);
    int res = map.put(24, 24);

    System.out.print(Arrays.toString(map.getTable()));

    assertEquals(res, 23);
    assertEquals("[null, null, null, null, null, null, (19, 19), null, (8, 8), null, null, (11, 11), null]", Arrays.toString(map.getTable()));

    ExternalChainingMapEntry node = map.getTable()[11];
    assertEquals(node.getValue(), 11);
    assertEquals(node.getNext().getValue(), 24);
    assertEquals(node.getNext().getNext().getValue(), 37);

  }



  // resize required
}
