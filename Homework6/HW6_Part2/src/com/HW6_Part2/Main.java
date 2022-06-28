package com.HW6_Part2;

public class Main {

    public static void main(String[] args) {
	QuickSort mytest = new QuickSort();
	MergeSort mytestMerge = new MergeSort();
	newSort mytestNewSort = new newSort();
    int []testArray = new int [10000];
    newSort myNewSortTest = new newSort();
        double start = System.currentTimeMillis();
        double end = System.currentTimeMillis();
        double elapsedTime = end - start;
    Integer[] mytestarr = new Integer[10000];
    int [] mytestarr2 = new int[10000];
        //mytestarr = myNewSortTest.newSort(testArray,0,9);

    for(int i=0;i<10000;i++){
    mytestarr[i] = 10000-i;
    }
        System.out.println("** Sorting 10000 ELEMENTS With Quick Sort Algorithm **");
        for(int i=0;i<10000;i++){
System.out.print(mytestarr[i] + " ");        }
        System.out.println();
        System.out.println();
        start = System.currentTimeMillis();
    mytest.sort(mytestarr);

        for(int i=0;i<10000;i++){
            System.out.print(mytestarr[i] + " ");        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println();
        System.out.println("Total execution time of 10000 element in Quick Sort is: " + elapsedTime + "ms.");

        for(int i=0;i<10000;i++){
            mytestarr[i] = 10000-i;
        }
        System.out.println("** Sorting 10000 ELEMENTS With Merge Sort Algorithm **");
        for(int i=0;i<10000;i++){
            mytestarr[i] = 10000-i;
        }

        for(int i=0;i<10000;i++){
            System.out.print(mytestarr[i] + " ");        }
        System.out.println();
        System.out.println();
        start = System.currentTimeMillis();
        mytestMerge.sort(mytestarr);

        for(int i=0;i<10000;i++){
            System.out.print(mytestarr[i] + " ");        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println();
        System.out.println("Total execution time of 10000 element in Merge Sort is: " + elapsedTime + "ms.");

        System.out.println("** Sorting 10000 ELEMENTS With  New Sort Algorithm **");
        for(int i=0;i<10000;i++){
            mytestarr2[i] = 10000-i;
        }
        for(int i=0;i<10000;i++){
            System.out.print(mytestarr2[i] + " ");        }
        System.out.println();
        System.out.println();
        start = System.currentTimeMillis();
        myNewSortTest.newSort(mytestarr2,0,9999);

        for(int i=0;i<10000;i++){
            System.out.print(mytestarr2[i] + " ");        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println();
        System.out.println("Total execution time of 10000 element in New Sort Sort is: " + elapsedTime + "ms.");


    }
}
