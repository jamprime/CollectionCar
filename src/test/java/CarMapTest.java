import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {

    private CarMap carMap;
    @BeforeEach
    void setUp() {
        carMap = new CarHashMap();
    }

    @Test
    void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++){
            CarOwner carOwner= new CarOwner(i, "name" + i, "lastname" + i);
            Car car = new Car("Machine" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
    }

    @Test
    void whenPut100ElementsWith10DifferentKeysThenSizeBecome10() {
        for (int i = 0; i < 100; i++){
            int index = i % 10;
            CarOwner carOwner= new CarOwner(index, "name" + index, "lastname" + index);
            Car car = new Car("Machine" + index, index);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());
    }

    @Test
    void removeReturnTrueOnlyOnce(){
        for (int i = 0; i < 10; i++){
            CarOwner carOwner= new CarOwner(i, "name" + i, "lastname" + i);
            Car car = new Car("Machine" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());
        CarOwner newCarOwner = new CarOwner(4, "name4", "lastname4");
        assertTrue(carMap.remove(newCarOwner));
        assertEquals(9, carMap.size());
        assertFalse(carMap.remove(newCarOwner));
    }

    @Test
    void countOfKeysMustBeEqualsCountOfValues(){
        for (int i = 0; i < 100; i++){
            CarOwner carOwner= new CarOwner(i, "name" + i, "lastname" + i);
            Car car = new Car("Machine" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
        assertEquals(100, carMap.keySet().size());
        assertEquals(100, carMap.values().size());

    }

    @Test
    void methodGetMustReturnTrueValues(){
        for (int i = 0; i < 100; i++){
            CarOwner carOwner= new CarOwner(i, "name" + i, "lastname" + i);
            Car car = new Car("Machine" + i, i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
        assertEquals("Machine49", carMap.get(new CarOwner(49, "name49", "lastname49")).getBrand());
    }
}