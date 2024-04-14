import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {

    private CarQueue carQueue;

    @BeforeEach
    void setUp() {
        carQueue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            carQueue.add(new Car("machine" + i, i));
        }
    }

    @Test
    void whenAdd10CarsThenSizeMustBe10() {
        assertTrue(carQueue.add(new Car("machine" + 100, 100)));
        assertEquals(11, carQueue.size());
    }

    @Test
    void peak() {
        assertEquals(new Car("machine" + 0, 0), carQueue.peak());
        assertEquals(10, carQueue.size());
    }

    @Test
    void pull() {
        assertEquals(new Car("machine" + 0, 0), carQueue.pull());
        assertEquals(9, carQueue.size());
    }
}