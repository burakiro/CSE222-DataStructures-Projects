package com.HomeWork5;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Concrete class of heap data structure.
 * @param <E> type
 */
public class TernaryHeap<E extends Comparable<E> >{

    /**
     * List of data.
     */
    protected ArrayList<BinaryTree.Node> dataOfHeap;

    /**
     * Comparator.
     */
    Comparator<BinaryTree.Node > comparator = null;

    /**
     * Return left child index;
     * @param parentIndex parent index
     * @return left child index;
     */
    protected int getLeftChildIndex( int parentIndex ) {
        return 3 * parentIndex + 1;
    }


    protected int getMiddleChildIndex( int parentIndex ) {
        return 3 * parentIndex + 2;
    }


    /**
     * Return right child index;
     * @param parentIndex parent index
     * @return right child index;
     */
    protected int getRightChildIndex( int parentIndex ) {
        return 3 * parentIndex + 3;
    }

    /**
     * Return parent index.
     * @param childIndex child index.
     * @return parent index;
     */
    protected int getParentIndex( int childIndex ) {
        return ( childIndex - 1 ) / 3;
    }

    /**
     * Determine the certain index element has left child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasLeftChild( int index ) {
        return getLeftChildIndex( index ) < dataOfHeap.size();
    }


    protected boolean hasMiddleChild( int index ) {
        return getMiddleChildIndex( index ) < dataOfHeap.size();
    }

    //has middle child

    /**
     * Determine the certain index element has right child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasRightChild( int index ) {
        return getRightChildIndex( index ) < dataOfHeap.size();
    }

    /**
     * Determine the certain index element has parent child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasParent( int index ) {
        return getParentIndex( index ) >= 0;
    }

    /**
     * Return left child.
     * @param index index
     * @return left child.
     */
    protected BinaryTree.Node leftChild( int index ) {
        return dataOfHeap.get( getLeftChildIndex( index ) );
    }

    protected BinaryTree.Node middleChild( int index ) {
        return dataOfHeap.get( getMiddleChildIndex( index ) );
    }


    /**
     * Return right child.
     * @param index index
     * @return right child.
     */
    protected BinaryTree.Node  rightChild( int index ) {
        return dataOfHeap.get( getRightChildIndex( index ) );
    }

    /**
     * Return parent.
     * @param index index
     * @return parent.
     */
    protected BinaryTree.Node  parent( int index ) {
        return dataOfHeap.get( getParentIndex( index ) );
    }

    /**
     * Compare the two different element in the heap according to comparator.
     * @param left left
     * @param right right
     * @return compare method result if it does not exist return the result compareTo method of element.
     */
    protected int compare( BinaryTree.Node  left  , BinaryTree.Node  right ) {

        if( comparator != null ) {
            return comparator.compare( left ,right );
        } else {
            return left.data.compareTo(right.data);
        }

    }

    /**
     * Swap the elements.
     * @param i first index.
     * @param j second index.
     */
    protected void swap( int i , int  j ) {

        if ( i < 0 || j < 0 || (i > dataOfHeap.size() - 1)
                || (j > dataOfHeap.size() - 1) ) {
            throw new IndexOutOfBoundsException();
        }

        BinaryTree.Node  tempData = dataOfHeap.get(i);
        dataOfHeap.set( i , dataOfHeap.get(j) );
        dataOfHeap.set( j , tempData );

    }

    /**
     * Heapify throughout up in tree design.
     */
    protected void heapifyUp() {

        int index = dataOfHeap.size() - 1;

        while ( hasParent( index ) && ( compare( parent( index ) , dataOfHeap.get( index ) ) < 0 ) ) { //O(N)
            swap( getParentIndex( index ) , index );
            index = getParentIndex( index );
        }

    }

    /**
     * Update the current status of Heap.
     */

    /*
    protected void updateHeap() {
        TernaryHeap<E> newHeap;

        if( comparator != null ) {
            newHeap = new TernaryHeap<E>( comparatorHeap );
            for (BinaryTree.Node theDatum : theData) {
                newHeap.add( theDatum );
            }

            theData = newHeap.theData;
        }
    }*/

    /**
     * No parameter constructor.
     */
    public TernaryHeap() {
        dataOfHeap = new ArrayList<BinaryTree.Node>();
    }

    /**
     * Initiate a heap with given comparator.
     * @param comp Comparator.
     */
    public TernaryHeap( Comparator<BinaryTree.Node> comp ) {
        this();
        comparator = comp;
    }

    /**
     * Return the first element of the heap.
     * @return first element of the heap.
     */

    public BinaryTree.Node peek() {
        if( dataOfHeap.size() == 0 ) {
            throw new IllegalStateException();
        }

        return dataOfHeap.get( 0 );
    }

    /**
     * Pull out the first element of the heap.
     * @return first element of the heap.
     */

    /**
     * Find a specific element and return it.
     * @param item item
     * @return element itself if it is not found return null.
     */

    public BinaryTree.Node find( BinaryTree.Node  item ) {

        for (BinaryTree.Node theDatum : dataOfHeap) {
            if ( theDatum.data.compareTo(item.data ) == 0 ) {
                return theDatum;
            }
        }

        return null;
    }

    /**
     * Add the element to the heap.
     * @param item item
     */


    public void add( BinaryTree.Node item ) {
        dataOfHeap.add( item ); //O(1)
        heapifyUp();
    }


    public boolean incrementKeyValue(int index, E newValue){
        if(index > dataOfHeap.size()){
            System.out.println("Index can not be greater than size of heap!");
            return false;
        }

        dataOfHeap.remove(dataOfHeap.get(index)); // O(N)
        this.add(new BinaryTree.Node(newValue));
        return true;
    }

    public boolean removeEelement(BinaryTree.Node item){
        dataOfHeap.remove(item);

       TernaryHeap<E> myTempHeap= new TernaryHeap<E>();

       for(int i=0;i<this.dataOfHeap.size();i++){//O(N)
           myTempHeap.add(dataOfHeap.get(i));//O(1)
       }
       this.dataOfHeap.clear();

        for(int i=0;i<myTempHeap.dataOfHeap.size();i++){//O(N)
            this.add(myTempHeap.dataOfHeap.get(i));//O(1)
        }


        return true;
    }



    public boolean mergeHeaps(TernaryHeap<E> input) {

        for(int i = 0; i<input.dataOfHeap.size(); i++){//O(N)
            this.add(input.dataOfHeap.get(i));//O(1)
        }
        return true;
    }


    /**
     * String representation of heap.
     * @return String representation of heap.
     */
    @Override
    public String toString() {
        return dataOfHeap.toString();
    }


}