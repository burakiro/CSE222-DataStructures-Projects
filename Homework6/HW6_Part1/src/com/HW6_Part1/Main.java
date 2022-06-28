package com.HW6_Part1;
public class Main {

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        double end = System.currentTimeMillis();
        double elapsedTime = end - start;
        /*
        HashtableChain<Integer, Integer> myTable = new HashtableChain<Integer, Integer>();
        myTable.put(5,1);
        myTable.put(6,2);
        myTable.put(7,3);
        myTable.put(8,4);
        myTable.put(5,9);
        myTable.put(5,11);
        myTable.put(5,8);
        myTable.put(5,2);
        myTable.put(5,1);
        myTable.put(5,0);
        myTable.get(5);*/

    /*
        HashtableCoalesced<Integer,Integer> table1 = new HashtableCoalesced<>(10);
        table1.put(3,10);
        table1.put(12,111);
        table1.put(13,0000);
        table1.put(12,13);
        table1.put(25,17);
        table1.put(23,129);
        table1.put(51,31);
        System.out.println(table1);
        table1.remove(25);
        System.out.println(table1);*/

        /*
        HashtableCoalesced<Integer,Integer> lmap1 = new HashtableCoalesced<>(100);
        System.out.println("Coalesced Version");
        System.out.println("*************************Map1**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 100 ELEMENTS TO COALESCED HASHTABLE **");
        for(int i = 0;i< 100;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + lmap1.size()+" add current i (Value) val:"+lmap1.put(i, i)+" size after add :" + lmap1.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);*/

/*
        HashtableCoalesced<Integer,Integer> lmap2 = new HashtableCoalesced<>(1000);
        System.out.println("*************************Map2**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 1000 ELEMENTS TO COALESCED HASHTABLE **");
        for(int i = 0;i< 1000;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + lmap2.size()+" add current i (Value) val:"+lmap2.put(i, i)+" size after add :" + lmap2.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);*/
/*

        HashtableCoalesced<Integer,Integer> lmap3 = new HashtableCoalesced<>(10000);
        System.out.println("*************************Map3**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 10000 ELEMENTS TO COALESCED HASHTABLE **");
        for(int i = 0;i< 10000;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + lmap3.size()+" add current i (Value) val:"+lmap3.put(i, i)+" size after add :" + lmap3.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);*/

/*
        System.out.println("Chain Version");
        HashtableChain<Integer, Integer> map1 = new HashtableChain<Integer, Integer>();
        System.out.println("*************************Map1**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 100 ELEMENTS TO CHAIN HASHTABLE **");
        for(int i = 0;i< 100;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + map1.size()+" add current i (Value) val:"+map1.put(i, i)+" size after add :" + map1.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);*/
/*
        HashtableChain<Integer, Integer> map2 = new HashtableChain<Integer, Integer>();
        System.out.println("*************************Map2**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 1000 ELEMENTS TO CHAIN HASHTABLE **");
        for(int i = 0;i< 1000;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + map2.size()+" add current i (Value) val:"+map2.put(i, i)+" size after add :" + map2.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);
*/


        HashtableChain<Integer, Integer> map3 = new HashtableChain<Integer, Integer>();
        System.out.println("*************************Map3**************************");
        //add some elements
        start = System.currentTimeMillis();
        System.out.println("** ADD 10000 ELEMENTS TO CHAIN HASHTABLE **");
        for(int i = 0;i< 10000;i++){

            System.out.println("Current i (Key) val :"+i+" size before add :" + map3.size()+" add current i (Value) val:"+map3.put(i, i)+" size after add :" + map3.size());
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Total time for this execution : "+ elapsedTime);




    }
}
