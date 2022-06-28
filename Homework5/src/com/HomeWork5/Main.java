package com.HomeWork5;

public class Main {

    public static void main(String[] args) {

        TernaryHeap<Integer> myTestTernaryHeap1 = new TernaryHeap<Integer>();
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(90));

        BinaryTree.Node<Integer> myTest = new BinaryTree.Node<Integer>(10000);
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(200));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(-9));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(1));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(-55));
        myTestTernaryHeap1.add(myTest);
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(77));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(50));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(11));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(600));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(-789));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(123));
        myTestTernaryHeap1.add(new BinaryTree.Node<Integer>(2));

        //System.out.println(myTestTernaryHeap1.toString());

        myTestTernaryHeap1.incrementKeyValue(2,1100);

        System.out.println(myTestTernaryHeap1.toString());

        //System.out.println(myTestTernaryHeap1.toString());

/*

        BST<Integer> myBSTTest = new BST<Integer>(20);

        myBSTTest.add(3);
        myBSTTest.add(1);
        myBSTTest.add(4);
        myBSTTest.add(9);
        myBSTTest.add(2);
        myBSTTest.add(5);
        myBSTTest.add(0);


        System.out.println(myBSTTest.delete(3));
        System.out.println(myBSTTest.delete(99999));

*/
    }
}
