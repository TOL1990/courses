package com.courses.spalah.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Leonid on 11.03.2016.
 */
public class SinglyLinkedList<E> implements MyList {
    private Noda<E>  prevObj; //firstObj
    private Noda<E>  nextObj;
    private Noda<E>  currentObj;
    private int index;
    private int size;

    public SinglyLinkedList() {
       prevObj = new Noda(null);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;

        else return false;
    }

    @Override
    public boolean add(Object element) {
//        Noda newNoda = new Noda(element, prevObj);
        Noda newNode = new Noda(element, null);
        nextObj = prevObj;
        while (nextObj.getNextObj() != null) {
            nextObj = nextObj.getNextObj();
        }
        nextObj.setNextObj(newNode);
        size++;
        return true;
    }
    @Override
    public void add(int index, Object element) {

        Noda newNode = new Noda(element, null);
        currentObj = getNodaWithIndex(index-1);
        nextObj = currentObj.getNextObj();
        currentObj.setNextObj(newNode);
        newNode.setNextObj(nextObj);

//        currentObj.getNextObj().setNextObj(nextObj);// many trable
        size++;
    }

    private Noda getNodaWithIndex(int index)
    {
        nextObj = prevObj;
        for (int i = 0; i <= index; i++) {
            nextObj = nextObj.getNextObj();
        }
        return nextObj;
    }

    @Override
    public void remove(int index) {
    currentObj = getNodaWithIndex(index - 1);
        nextObj = currentObj.getNextObj();
        currentObj.setNextObj(nextObj);
        size--;
    }

    @Override
    public Object get(int index)
    {
        currentObj = getNodaWithIndex(index); 
        return currentObj.getObj();

    }

    @Override
    public Object set(int index, Object element) {
        currentObj = getNodaWithIndex(index);
        //Fix and dell
        currentObj.setObj((E) element);
        return null;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }


}
