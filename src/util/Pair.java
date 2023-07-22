package util;

public class Pair<T1, T2> {
    T1 a;
    T2 b;

    public Pair(T1 a, T2 b) {
        this.a = a;
        this.b = b;
    }

    T1 getFirst() {
        return a;
    }

    T2 getSecond(){
        return b;
    }
}