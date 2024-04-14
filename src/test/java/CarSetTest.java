import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++){
            carSet.add(new Car("Machine", i));
        }
    }

    @Test
    public void whenAddExistedElementThenReturnFalse(){
        assertEquals(100, carSet.size());
        Car car = new Car("Toyota", 200);
        assertTrue(carSet.add(car));
        assertFalse(carSet.add(car));
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenRemoveNonExistedElementThenReturnFlase(){
        assertEquals(100, carSet.size());
        Car car = new Car("Toyota", 200);
        assertTrue(carSet.add(car));
        assertEquals(101, carSet.size());
        assertTrue(carSet.remove(car));
        assertEquals(100, carSet.size());
        assertFalse(carSet.remove(car));
    }

    @Test
    public void whenClearedSetThenSize0(){
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void ifContainsElementInArrayThenReturnTrue(){
        Car car = new Car("Toyota", 200);
        assertTrue(carSet.add(car));
        assertTrue(carSet.contains(car));
        assertTrue(carSet.remove(car));
        assertFalse(carSet.contains(car));
    }
}