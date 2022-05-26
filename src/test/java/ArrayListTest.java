import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

public class ArrayListTest {

    private ArrayList<Integer> arrayList;

    @BeforeAll
    public static void setupAll() {
        // System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setup() {
        // System.out.println("Instantiating Contact Manager");
        arrayList = new ArrayList<Integer>();
    }

    @Test
    @DisplayName("Should get the size")
    public void size() {
        arrayList.size();
        System.out.println("Size: " + arrayList.size());
    }

    @Test
    @DisplayName("Should addToBack")
    public void addToBack() {
        for (int i = 0; i < 10; i++) {
            arrayList.addToBack(i + 1);
        }
        assertEquals(10, arrayList.size());
    }

    @Test
    @DisplayName("Should fail if null addToBack")
    public void nullAddToBack() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            arrayList.addToBack(null);
        });
    }

    @Test
    @DisplayName("Should addToFront")
    public void addToFront() {
        for (int i = 0; i <= 8; i++) {
            arrayList.addToFront(i);
        }
        assertEquals(9, arrayList.size());
    }

    @Test
    @DisplayName("Should fail if empty removeFromFront")
    public void emptyRemoveFromFront() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            arrayList.removeFromFront();
        });
    }

    @Test
    @DisplayName("Should removeFromFront")
    public void removeFromFront() {
        for (int i = 0; i <= 8; i++) {
            arrayList.addToBack(i);
        }
        int removed = arrayList.removeFromFront();
        assertEquals(0, removed);
        assertEquals(8, arrayList.size());
    }

    @Test
    @DisplayName("Should removeFromBack")
    public void removeFromBack() {
        for (int i = 0; i <= 10; i++) {
            arrayList.addToBack(i);
        }
        int removed = arrayList.removeFromBack();

        assertEquals(10, removed);
        assertEquals(10, arrayList.size());

        System.out.println(Arrays.toString(arrayList.getBackingArray()));
        System.out.println(arrayList.size());
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
