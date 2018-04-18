package vendingMachine.components;

public class Bucket<E1, E2, E3, E4> {

    private E1 first;
    private E2 second;
    private E3 third;
    private E4 fourth;

    public Bucket(E1 first, E2 second, E3 third, E4 fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public E3 getThird() { return third;}

    public E4 getFourth() { return fourth;}
}
