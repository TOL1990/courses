package com.courses.spalah.list;

/**
 * Created by Leonid on 11.03.2016.
 */
public class Noda <E>
{
    private E obj;
    private Noda<E> nextObj;


    public Noda(Noda nextE) {
        obj = null;
        this.nextObj = nextE;
    }

        public Noda(E e, Noda<E> nextObjL) {
        this.obj = e;
        this.nextObj = nextObjL;
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

    public void clear()
    {
        obj = null;
        nextObj = null;
    }
    @Override
    public String toString() {
        return obj.toString();
    }
}
