import java.util.Iterator;

public class CarLinkedList implements CarList, CarQueue{

    private Node first;
    private Node last;
    private int size = 0;
    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secodLast = last;
            last = new Node(secodLast, car, null);
            secodLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public Car peak() {
        Node node = first;
        return node.value;
    }

    @Override
    public Car pull() {
        Node node = first;
        removeAt(0);
        return node.value;
    }


    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == size) {
            return add(car);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        }
        else {
            first = newNode;
        }
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)){
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        if (node.previous != null){
            node.previous.next = node.next;
        }
        else {
            first = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        else{
            last = node.previous;
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
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)){
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Node first = null;
        Node last = null;
        size = 0;
    }

    private Node getNode(int index) {
        if (index > size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }
            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car ;
            }
        };
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
