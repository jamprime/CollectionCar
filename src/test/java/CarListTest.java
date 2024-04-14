import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {


    private CarList carList;
    @BeforeEach
    void setUp() {
        carList = new CarLinkedList();
        //carList = new CarArrayList();
        for (int i = 0; i < 100; i++){
            carList.add(new Car("Machine", i));
        }
    }

    @Test
    public void whenAdded100elementsThenSizeMustBe100(){
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemovedElementAtIndexThenSizeMustBeDeacreased(){
        assertEquals(100, carList.size());
        carList.removeAt(99);
        assertEquals(99, carList.size());
    }

    @Test
    public void whenRemovedElementThenSizeMustBEDeacreased(){
        Car car = new Car("Toyota", 200);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void InsertIntoMiddle(){
        Car car = new Car("Toyota", 200);
        carList.add(car, 50);
        Car CarFromList = carList.get(50);
        assertEquals("Toyota", CarFromList.getBrand());
    }

    @Test
    public void InsetToTheEnd(){
        Car car = new Car("Toyota", 200);
        carList.add(car, 100);
        Car CarFromList = carList.get(100);
        assertEquals("Toyota", CarFromList.getBrand());
    }

    @Test
    public void InsertIntoFirst(){
        Car car = new Car("Toyota", 200);
        carList.add(car, 0);
        Car CarFromList = carList.get(0);
        assertEquals("Toyota", CarFromList.getBrand());
    }

    @Test
    public void ifContainsElementInArrayThenReturnTrue(){
        Car car = new Car("Toyota", 200);
        assertTrue(carList.add(car));
        assertTrue(carList.contains(car));
        assertTrue(carList.remove(car));
        assertFalse(carList.contains(car));
        assertFalse(carList.remove(car));
    }



}