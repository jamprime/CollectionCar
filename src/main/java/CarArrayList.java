import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList implements CarList {

    private Car[] array = new Car[10];
    private int size = 0;
    @Override
    public Car get(int index) {
        if (index < size && index >= 0)
            return array[index];
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(Car car) {
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index){
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(car))
                return removeAt(i);
        }
        return false;
    }


    @Override
    public boolean removeAt(int index) {
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Car car) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(car)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public Car next() {
                return array[index++];
            }
        };
    }
}
