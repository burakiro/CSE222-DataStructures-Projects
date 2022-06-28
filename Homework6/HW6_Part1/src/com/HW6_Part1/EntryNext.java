/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HW6_Part1;

public class EntryNext<K, V> implements Comparable<K>{
    /** The key */
    private final K key;
    /** The value */
    private V value;
    EntryNext<K,V> next;
    int idx;
    
    public EntryNext<K, V> getNext() {
        return next;
    }

    public void setNext(EntryNext<K, V> next) {
        this.next = next;
    }
    

    //@param key The key
    //@param value The value

    public EntryNext(K key, V value) {
    this.key = key;
    this.value = value;
    }
    /** Retrieves the key.
    @return The key
    */
    public K getKey() {
    return key;
    }
    /** Retrieves the value.
    @return The value
    */
    public V getValue() {
    return value;
    }
    /** Sets the value.
    @param val The new value
    @return The old value
    */
    public V setValue(V val) {
    V oldVal = value;
    value = val;
    return oldVal;
    }

    @Override
    public int compareTo(K o) {
        if(o.hashCode() > key.hashCode()) return -1;
        if(o.hashCode() < key.hashCode()) return 1;
        return 0;
    }
}