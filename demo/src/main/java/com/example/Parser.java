package com.example;

public interface Parser<T> {
    public abstract T parse(String parseString) throws ParseException;
}
