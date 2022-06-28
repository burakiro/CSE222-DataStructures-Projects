package com.HW6_Part2;

public class newSort
{
    int myTestArray [];
    public newSort() {
    }

    private int findMinIndex(int [] Array, int head, int tail){
        int minElem= Array[head];
        int minIndex=head;
        for(int i=head;i<tail+1;i++){
            if(Array[i] < minElem ){
                minElem = Array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    private int findMaxIndex(int [] Array, int head, int tail){
        int maxElem=Array[tail];
        int maxIndex=tail;
        for(int i=head;i<tail+1;i++){
            if(Array[i] > maxElem ){
                maxElem = Array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int [] newSort(int [] Array, int head, int tail){

        if(head > tail){
            return Array;
        }
        else{
            int min= findMinIndex(Array,head,tail);


            int temp;
            temp = Array[head];
            Array[head] = Array[min];
            Array[min] = temp;

            int max = findMaxIndex(Array,head,tail);

            temp = Array[tail];
            Array[tail] = Array[max];
            Array[max] = temp;

            return newSort(Array,head+1,tail-1);

        }

    }
}
