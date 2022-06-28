/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.HW6_Part1;
import java.util.LinkedList;

/**
 *
 * @author omera
 */

public class HashtableCoalesced<K,V> implements KWHashMap<K, V>{
    
    // Insert inner class Entry<K, V> here.
    /** The table */
    private LinkedList<EntryNext<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private int TABLESIZE;

    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 0.5;
    // Constructor
    public HashtableCoalesced(int tableSizeOfHash) {
        TABLESIZE = tableSizeOfHash;
        table = new LinkedList[TABLESIZE];
    }
    
    
    
    /** Method get for class HashtableChainLinkedList.
    @param key The key being sought
    @return The value associated with this key if found;
    otherwise, null
    */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % TABLESIZE;
        if (index < 0)
        index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        EntryNext<K,V> temp = table[index].get(0);
        // Search the list at table[index] to find the key.
        while (temp!=null) {            //maybe not in  check it 
            if(temp.getKey().equals(key))
                return temp.getValue();
            temp = temp.next;
        }
        // assert: key is not in the table.
        return null;
    }

    private int findMaxPrimeNumber(int input) {
        boolean flag = false;
        for (int i = 2; i <= input / 2; ++i) {
            // condition for nonprime number
            if (input % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return (int) input;
        else
            return findMaxPrimeNumber(input -1);

    }
    public int findMaxPrimeNumber(){
        return findMaxPrimeNumber((int) (TABLESIZE*0.8));
    }

    public int hasher(int key, int ithprobe){
        int primeNumber = findMaxPrimeNumber();
        int hash1 = key % TABLESIZE;
        int hash2 = primeNumber - (key % primeNumber);
        return (hash1 + (ithprobe * hash2)) % TABLESIZE;

    }

    /** Method put for class HashtableChainLinkedList.
    table and numKeys is incremented. If the key is already
    in the table, its value is changed to the argument
    value and numKeys is not changed.
    @param key The key of item being inserted
    @param value The value for this key
    @return The old value associated with this key if
    found; otherwise, null
    */
    @Override
    public V put(K key, V value) {
       /* int index = hasher(key.hashCode(),1);
        System.out.println("index: " + index);
        if (numKeys > (LOAD_THRESHOLD * TABLESIZE))
            rehash(true);
        if (index < 0)
            index += TABLESIZE;
        if (table[index] == null) {
        // Create a new linked list at table[index].
            table[index] = new LinkedList<EntryNext<K,V>>();
            table[index].add(new EntryNext<K,V>(key,value));
            return null;
        }*/

        for(int i = 1  , prev = -1;i<TABLESIZE;i++){
            int cur = hasher(key.hashCode(),i);
            //System.out.println("cur: " + index);
            if(cur < 0) cur+= TABLESIZE;
            if(table[cur] == null){
                table[cur] = new LinkedList<EntryNext<K,V>>();
                table[cur].add(new EntryNext<K,V>(key,value));
                table[cur].get(0).idx = cur;
                if(prev != -1)
                    table[prev].get(0).next = table[cur].get(0);
                break;
            }
            else if(table[cur].get(0).getKey().equals(key)){
                V res = table[cur].get(0).getValue();
                table[cur].get(0).setValue(value);
                numKeys++;
                return res;
            }
                prev = (cur);
        }
        numKeys++;
        
        return value;
   }
    

    @Override
    public V remove(Object key) {
        V res = null;
        int index = hasher(key.hashCode(),1);
        if(index < 0)
            index+= table.length;
        if (table[index] == null) 
        // Create a new linked list at table[index].
            return null;
        
        // Search the list at table[index] to find the key.
        for(int i = 1  , prev = -1;i<TABLESIZE;i++){
            int cur = hasher(key.hashCode(),i);
            if(table[cur] == null) break;
            if(table[cur].get(0).getKey().equals(key)){
                res = table[cur].get(0).getValue();
                if(prev != -1)
                    table[prev].get(0).next = table[cur].get(0).next;
                table[cur] = null;
                break;
            }
            if(table[cur].get(0).getKey().hashCode()%TABLESIZE == key.hashCode()%TABLESIZE)
                prev = (cur);
        }
        rehash(false);
        return res;
        /*      
        1. Set index to key.hashCode() % table.length.
        2. if index is negative, add table.length.
        3. if table[index] is null
        4. key is not in the table; return null.
        5. Search the list at table[index] to find the key
        6. if the search is successful
        7. Remove the entry with this key and decrement numKeys.
        8. if the list at table[index] is empty
        9. Set table[index] to null.
        10. Return the value associated with this key.
        11. The key is not in the table; return null.
        */
    }
    
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
    @post The size of the table is doubled and is an odd integer.
    Each nondeleted entry from the original table is
    reinserted into the expanded table.
    The value of numKeys is reset to the number of items
    actually inserted; numDeletes is reset to 0.
    */
    private void rehash(boolean check) {
        // Save a reference to oldTable.
        LinkedList<EntryNext<K, V>>[] oldTable = table;
        // Double capacity of this table.
        if(check)
            table = new LinkedList[2 * oldTable.length + 1];
        else 
            table = new LinkedList[oldTable.length];
        // Reinsert all items in oldTable into expanded table.
        TABLESIZE = table.length;
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null)) {
            // Insert entry in expanded table
                put(oldTable[i].get(0).getKey(), oldTable[i].get(0).getValue());
            }
        }
    }
    /**
     * returns size
     * @return 
     */
    @Override
    public int size() {
       return  numKeys;
    }
    /**
     * returns cap just for check
     * @return 
     */
    public int cap(){
        return TABLESIZE;
    }
    /**
     * checks is empty
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public String toString() {
        
        String res = "";
        for(int i =0;i<TABLESIZE;i++){
            if(i%TABLESIZE == 0){
                res+=("\n\n\nIndex\tHash Value\tKey\tVal\tNext\n");
            }
            res+=(i+"\t");
            res+=(i%TABLESIZE+"\t");
            if(table[i] != null && table[i].size()>0){
                res+=("\t"+table[i].get(0).getKey()+"\t"+table[i].get(0).getValue()+"\t");
            }
            else
                res+=("\t\t\t");
            
            if(table[i] != null && table[i].size()>0 && table[i].get(0).next != null){
                res+=(table[i].get(0).next.idx+"\t\n");
            }
            else
                res+=("NULL\t\n");
        }
        
        
        
        return res;
    }
    
}
