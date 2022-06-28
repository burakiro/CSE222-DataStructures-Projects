public class Main {

    public static void main(String[] args) {
	    BinaryTree<Integer> myPart1TestBinaryTree = new BinaryTree<Integer>();
	    Integer testArray[] = {-7,0,1,4,9,13,5,6};
        BinarySearchTree<Integer> result = new BinarySearchTree<Integer>();
        System.out.println("Print Q1 Method Test Tree with another array.");
        result = result.arrayToBST(myPart1TestBinaryTree,testArray);
	    System.out.println(result.toString());
		AVLTree<Integer> myPart2AVLTest = result.BSTToAVL(result);
        //myPart1TestBST.BSTToAVL(myPart1TestBST , myPart2AVLTest);
        //System.out.println("Print Q2 Method AVL Test Tree with another array");
	//System.out.println(myPart2AVLTest.toString());
    }
}
