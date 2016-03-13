package com.courses.spalah.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Leonid on 11.03.2016.
 */
public class SinglyLinkedList<E> implements MyList {
    protected Noda<E>  prevObj;
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
//        if(size == 0) return true;
//        else return false;

        return prevObj.getNextObj() == null; // 0_0 хз почему

    }

    @Override
    public boolean add(Object element) {

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
        currentObj.setNextObj(nextObj.getNextObj());
        size--;
    }

    @Override
    public Object get(int index)
    {
        nextObj = getNodaWithIndex(index);
        return nextObj.getObj();

    }

    @Override
    public Object set(int index, Object element) {
        nextObj = getNodaWithIndex(index);
        //Fix and dell
        nextObj.setObj((E) element);
        return null;
    }

    @Override
    public boolean contains(Object element) {
        nextObj = prevObj;
        while(nextObj.getNextObj() != null)
        {
            nextObj = nextObj.getNextObj();
            if(nextObj.getObj().equals(element)) return true;
        }
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Iterator iterator() {
//         return new MyIterator(); // Для внутреннего класа, кот не работает
        index = 0;
        nextObj = prevObj;

        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                if(nextObj.getNextObj() != null)
                {
                    nextObj = nextObj.getNextObj();
                    index++;
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                return nextObj.getObj();
            }

            @Override
            public void remove() {
                index--;
                SinglyLinkedList.this.remove(index);
                size--;
            }
        };
        return iterator;
    }



    // Why dont work?
//    @Override
//    public void forEach(Consumer action) {
//
//    }
    /*
    class MyIterator //implements Iterator
    {
        SinglyLinkedList.this
        prevObj
        public MyIterator(Noda first, int index) {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }*/

}
