package com.courses.spalah.list;

/**
 * Created by Leonid on 11.03.2016.
 */
public class Noda <E>
{
    private E obj;
    private Noda<E> nextObj;


    public Noda(E obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return obj.toString();
    }

    public Noda(E obj, Noda<E> nextObj) {
        obj = obj;
        this.nextObj = nextObj;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public Noda<E> getNextObj() {
        return nextObj;
    }

    public void setNextObj(Noda<E> nextObj) {
        this.nextObj = nextObj;
    }
}
