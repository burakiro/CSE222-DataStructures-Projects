package com.HomeWork5;
import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;

public class BST<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E > {
    protected boolean addReturn;
    protected E deleteReturn;

        // Member variables of this class
    static int size = 0;
        private E root;
        private Object[] BinarySearchTreeArray;

    public BST (int size) {
        BinarySearchTreeArray = new Object[size];
    }


    // Method 1
        // Creating root node
        public void Root(E key) { BinarySearchTreeArray[0] = key; }

        // Method 2
        // Creating left son of root
        public void set_Left(E key, int root)
        {
            int t = (root * 2) + 1;

            if (BinarySearchTreeArray[root] == null) {
                System.out.printf(
                        "Can't set child at %d, no parent found\n",
                        t);
            }
            else {
                BinarySearchTreeArray[t] = key;
            }
        }
/*
    public E[] getArray(int size) {
        E[] genericArray = new E[size];
        return genericArray;
    }*/

        // Method 3
        // Creating right son of root
        public void set_Right(E key, int root)
        {
            int t = (root * 2) + 2;

            if (BinarySearchTreeArray[root] == null) {
                System.out.printf(
                        "Can't set child at %d, no parent found\n",
                        t);
            }
            else {
                BinarySearchTreeArray[t] = key;
            }
        }

        // Method 4
        // To print our tree
        public String toString(int index) {
            return BinarySearchTreeArray[index].toString();
        }
        public void print_Tree()
        {

            // Iterating using for loop
            for (int i = 0; i < BinarySearchTreeArray.length; i++) {
                if (BinarySearchTreeArray[i] != null)
                    System.out.print(BinarySearchTreeArray[i].toString());
                else
                    System.out.print("-");
            }
        }



    @Override
    public boolean contains(E target) {
            for(int i=0;i<BinarySearchTreeArray.length;i++){//O(N)
                if(BinarySearchTreeArray[i] == target){ //O(1)
                    return true;
                }
            }
            return false;
    }

    @Override
    public E find(E target) {
        if(contains(target)){
            for(int i=0;i< BinarySearchTreeArray.length;i++){ //O(N)
               if(BinarySearchTreeArray[i] == target){
                   return (E) BinarySearchTreeArray[i]; //O(1)
               }
            }
        }
        return null;
    }

    @Override
    public E delete(E target) {

            if(!contains(target)){
                return null;
            }

            for(int i=0;i<size;i++){//O(N^2)
                if(BinarySearchTreeArray[i]==target){
                    BinarySearchTreeArray[i] = null;
                    for(int j=i;j< BinarySearchTreeArray.length-1;j++){//O(N)
                        BinarySearchTreeArray[j]=BinarySearchTreeArray[j+1];
                    }
                }
            }
        BST<E> myBSTnew = new BST<E>(100);

            for(int i=0;i< BinarySearchTreeArray.length;i++){
                if(BinarySearchTreeArray[i] != null){
                    myBSTnew.add((E) BinarySearchTreeArray[i]);
                }
            }
            for(int i=0;i< BinarySearchTreeArray.length;i++){
                BinarySearchTreeArray[i]= myBSTnew.BinarySearchTreeArray[i];
            }
            return target;
    }

    @Override
    public boolean remove(E target) {
            if(this.delete(target) != null){return true;}//O(N^2)
            else
        return false;
    }


    @Override
    public boolean add(E item){
        int index = 0;//O(1)
        int comp;//O(1)
        boolean not_add = true;//O(1)
        while(not_add)//O(N)
        {
            if (BinarySearchTreeArray[index] == null) //O(1)
            {
                BinarySearchTreeArray[index] = item;//O(1)
                not_add  = false;//O(1)
            }

            comp = ((Comparable)item).compareTo (BinarySearchTreeArray[index]);//O(1)

            if(comp == 0) not_add = false;//O(1)
            else if (comp < 0) index = index * 2 + 1;  //O(1)
            else index = index * 2 + 2; //O(1)
        }
        size++;
        return true;
        }


}
