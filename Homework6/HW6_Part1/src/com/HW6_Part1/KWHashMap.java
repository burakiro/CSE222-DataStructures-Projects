/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HW6_Part1;

/**
 *
 * @author omera
 */
public interface KWHashMap<K, V> {

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    int size();

    boolean isEmpty();
}