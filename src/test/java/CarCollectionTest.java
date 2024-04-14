import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {

    private CarCollection carCollection;
    @BeforeEach
    void setUp() {
        carCollection = new CarHashSet();
        for (int i = 0; i < 100; i++){
            carCollection.add(new Car("Machine" + i, i));
        }
    }

    @Test
     public void testForeach(){
        int index = 0;
        for (Car car : carCollection) {
            index++;
        }
        assertEquals(100, index);
    }

}