public interface CarCollection extends Iterable<Car>{
    boolean add(Car car);
    boolean remove(Car car);
    void clear();
    int size();
    boolean contains(Car car);
}
