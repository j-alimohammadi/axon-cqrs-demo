package com.example.axondemo.events;

public abstract class AbstractBaseEvent<T> {

    public final T id;

    public AbstractBaseEvent(T id) {
        this.id = id;
    }
}
