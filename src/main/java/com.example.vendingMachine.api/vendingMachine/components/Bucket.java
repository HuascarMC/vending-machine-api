package vendingMachine.components;

public class Bucket<E1, E2, E3> {

    private E1 first;
    private E2 second;
    private E3 third;

    public Bucket(E1 first, E2 second, E3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public E3 getThird() { return third;}
}
