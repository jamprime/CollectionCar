import java.util.*;

public class CarHashMap implements CarMap{
    private int size = 0;
    private static final int INIT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Entry[] array = new Entry[INIT_CAPACITY];

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= array.length * LOAD_FACTOR){
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
    }
    public boolean put(CarOwner key, Car value, Entry[] destination){
        int position = getElementPosition(key, destination.length);
        Entry existedElement = destination[position];
        if (existedElement == null){
            destination[position] = new Entry(key, value, null);
            return true;
        } else{
            while (true){
                if (existedElement.key.equals(key)){
                    existedElement.value = value;
                    return false;
                }
                if (existedElement.next == null){
                    existedElement.next = new Entry(key, value, null);
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
    }

    public int getElementPosition(CarOwner carOwner, int arrayLength){
        return Math.abs(carOwner.hashCode() % arrayLength);
    }
    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        while (existedElement != null){
            if (existedElement.key.equals(key)){
                return existedElement.value;
            }
            else {
                existedElement = existedElement.next;
            }
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null){
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<>();
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null){
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = array[position];
        if (existedElement != null && existedElement.key.equals(key)){
            array[position] = existedElement.next;
            size--;
            return true;
        } else {
            while (existedElement != null){
                existedElement = existedElement.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INIT_CAPACITY];
        size = 0;
    }

    public void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null){
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }
    public static class Entry{
        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
