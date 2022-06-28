package com.LDLinkedListStreet;

public class Node <E> {

        E data;
        Node next;

        Node(E data) {
                this.data = data;
                this.next = null;
        }

        public void setData(E data)
        {
                this.data = data;
        }

        public void setNext(Node<E> next)
        {
                this.next = next;
        }

        public E getData()
        {
                return data;
        }

        public Node<E> getNext()
        {
                return next;
        }

}
