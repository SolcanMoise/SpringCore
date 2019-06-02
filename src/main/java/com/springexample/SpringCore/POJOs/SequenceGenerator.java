package com.springexample.SpringCore.POJOs;

import java.beans.ConstructorProperties;

public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    private int counter;

    SequenceGenerator() {}

    public SequenceGenerator(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public SequenceGenerator(String prefix, int initial) {
        this.prefix = prefix;
        this.initial = initial;
    }

    // Allow Spring to look up the parameters name from the constructor
    @ConstructorProperties({"initial", "suffix"})
    public SequenceGenerator(int initial, String suffix) {
        this.initial = initial;
        this.suffix = suffix;
    }

    SequenceGenerator(String prefix, String suffix, int initial, int counter) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.initial = initial;
        this.counter = counter;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    String getPrefix() {
        return prefix;
    }

    String getSuffix() {
        return suffix;
    }

    int getInitial() {
        return initial;
    }

    int getCounter() {
        return counter;
    }

    public synchronized String getSequence() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(prefix);
        buffer.append(initial + counter++);
        buffer.append(suffix);
        return buffer.toString();
    }
}
