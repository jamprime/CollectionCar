public interface CarQueue extends CarCollection{
    boolean add(Car car);
    Car peak();
    Car pull();
}
