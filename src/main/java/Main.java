import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getNumber() > o2.getNumber()){
                    return 1;
                }
                if (o1.getNumber() < o2.getNumber()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });

    }
}
