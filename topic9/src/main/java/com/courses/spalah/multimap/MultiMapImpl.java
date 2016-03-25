package com.courses.spalah.multimap;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leonid on 15.03.2016.
 */
public class MultiMapImpl<K, V> implements MultiMap<K, V> {
    Map<K, ArrayList<V>> map;
    int size; //некрасиво канеш

    public MultiMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public boolean put(K key, V value) {
        if (map.containsKey(key)) {
            ArrayList valList = map.get(key);
            valList.add(value);
        } else {
            ArrayList<V> newList = new ArrayList();
            newList.add(value);
            map.put(key, newList);

        }
        return true;
    }

    @Override
    public Collection get(Object key) {
        ArrayList<V> list;
        list = map.get(key);
        if (!map.containsKey(key)) return new ArrayList<>();
        return list;
    }

    @Override
    public Collection removeAll(Object key) {
        ArrayList<V> list;

        list = map.get(key);

        if (!map.containsKey(key) ) return new ArrayList<>();

        ArrayList<V> removedList = new ArrayList<>(list);
        map.remove(key);
        return removedList;
    }

    @Override
    public boolean remove(Object key, Object value) {
        ArrayList<V> list;
        list = map.get(key);

        if (!map.containsKey(key) || !list.contains(value)) return false;

        list.remove(value);
        return true;
    }

    @Override
    public Collection allValues() {
        ArrayList list = new ArrayList();
        for (Map.Entry<K, ArrayList<V>> pair : map.entrySet()) {
            ArrayList value = pair.getValue();
            list.addAll(value);
        }
        return list;
    }

    @Override
    public boolean containsValue(Object value) {
        ArrayList list = new ArrayList();
        for (Map.Entry<K, ArrayList<V>> pair : map.entrySet()) {
            ArrayList valueList = pair.getValue();
            if (valueList.contains(value)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if ( size() == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return "MultiMapImpl{" +
                "map=" + map +
                '}';
    }

    @Override
    public int size() {
        int size = 0;
        for (Map.Entry<K, ArrayList<V>> pair : map.entrySet()) {
            ArrayList value = pair.getValue();
            size += value.size();
        }
        return size;
    }
}
