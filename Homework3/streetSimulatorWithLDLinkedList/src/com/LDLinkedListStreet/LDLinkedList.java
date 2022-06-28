package com.LDLinkedListStreet;

import java.util.*;

public class LDLinkedList<E> extends AbstractList<E> implements List<E>,Iterable<E>{
    Node<E> head;
    Node<E> current;

    LDLinkedList<E> deletedContent;

    public boolean add(E data)
    {

        // Create a new node with given data
        Node new_node = new Node(data);//O(1)
        //last points to last node of LDLinkedList.
        Node last = this.head;//O(1)
        if (this.head == null) {//O(1)
            this.head = new_node;//O(1)
            return true;
        }

        while(last.next != null){//O(N)
            last=last.next;//O(1)
        }

        if(deletedContent == null){//O(1)
            last.next = new_node;//O(1)
            return true;

        }
        if(deletedContent!= null){//O(1)
            current=deletedContent.head;//O(1)
            while(current != null){//O(N)
                if(data == current.data){//O(1)
                    last.next=current;//O(1)
                    last.next.next = null;//O(1)
                    System.out.println("The object/build found in the Deleted Content!");//O(1)
                    return true;
                }
                current=current.next;//O(1)
            }

        }

        last.next = new_node;//if couldn't find the create new node and go for it !
        return true;
    }

    // return Head
    public Node<E> getHead()
    {
        return head;
    }


    @Override
    public E get(int index) {
        int traverseIndex = 0;//O(1)
        current = this.head;//O(1)

        while(current != null){//O(N)
            if(traverseIndex == index){//O(1)
                return current.data;//O(1)
            }
            traverseIndex++;//O(1)
            current = current.next;//O(1)

        }
        return null;//O(1)
    }

    @Override
    public E set(int index, E element) {
        int traverseIndex = 0;//O(1)
        current = this.head;//O(1)

        while(current != null){//O(N)
            if(traverseIndex == index){//O(1)
                current.data = element;//O(1)
                return element;//O(1)
            }
            traverseIndex++;//O(1)
            current = current.next;//O(1)

        }
        return null;//O(1)
    }


    // implement if needed
    public E remove(int index)
    {
        if(deletedContent==null){ deletedContent = new LDLinkedList<E>();}//for the first call.O(1)
        current = this.head;//O(1)
        int currentIndex = 0;//O(1)
        E willDelete = null;//O(1)

        Node previousCurrent = null;

        while(current != null){//O(N)
            if(currentIndex == index - 1){
                previousCurrent=current;//O(1)
                deletedContent.add((E) current.next.data);//O(N)
                previousCurrent.next=current.next.next;//O(1)
            }
            if(currentIndex == index){

                    willDelete = current.data;//O(1)
                    current.next=null;//O(1)
                    return willDelete;//O(1)
            }
            currentIndex++;//O(1)
            current=current.next;//O(1)
        }

        return willDelete;//O(1)
    }

    @Override
    public int size() {
        int size = 0;//O(1)
        current = this.head;//O(1)
        while(current != null){//O(N)
            size++;//O(1)
            current=current.next;//O(1)
        }
        return size;//O(1)
    }
}
