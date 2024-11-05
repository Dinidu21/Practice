package com.dinidu.test.collectionsandgenerics;

public class Pair <T,U>{
     private T first;
     private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public Pair<T, U> setFirst(T first) {
        this.first = first;
        return this;
    }

    public U getSecond() {
        return second;
    }

    public Pair<T, U> setSecond(U second) {
        this.second = second;
        return this;
    }
}
