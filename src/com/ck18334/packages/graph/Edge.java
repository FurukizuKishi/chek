package com.ck18334.packages.graph;

import com.sun.istack.internal.NotNull;

public class Edge<T> {
    private T input;
    private State<T> destination;

    public Edge(T input, @NotNull State<T> destination) {
        this.input = input;
        this.destination = destination;
    }

    public State<T> getDestination() {
        return destination;
    }
    public T getInput() {
        return input;
    }

    public boolean equals(Edge<T> other) {
        return (getInput() == other.getInput() && getDestination() == other.getDestination());
    }
    public String toString() {
        return "X -" + input + "-> " + destination.toString(true);
    }

}
