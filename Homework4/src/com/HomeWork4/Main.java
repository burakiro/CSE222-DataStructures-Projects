package com.HomeWork4;

public class Main {

    public static void main(String[] args) {
        String test1 = "burakiroasdfiroasdaafasdgfiro";
        String test2 = "iro";


        System.out.println("**Test Case 1**");
        System.out.println("**Unexistence Occurence Index Test: **");
        myHw4Class HomeWork4 = new myHw4Class();
        System.out.println(HomeWork4.isContainString(test2, test1, 4));
        System.out.println();
        System.out.println("**Test Case 2**");
        System.out.println("**Return 1. Occurence Index Test: **");
        System.out.println(HomeWork4.isContainString(test2, test1, 1));
        System.out.println();
        System.out.println("**Test Case 3**");
        System.out.println("**Return 2. Occurence Index Test: **");
        System.out.println(HomeWork4.isContainString(test2, test1, 2));
        System.out.println();
        System.out.println("**Test Case 4**");
        System.out.println("**Return 3. Occurence Index Test: **");
        System.out.println(HomeWork4.isContainString(test2, test1, 3));
        System.out.println();
        System.out.println("**Test Case 5**");
        System.out.println("**Small String and Big String swap in function parameter call.**");
        System.out.println(HomeWork4.isContainString(test1, test2, 3));
        System.out.println();
        int[] testArray = {-30, -15, -7, -4, 0, 3, 9, 15, 17, 20};
        int result;

        result = HomeWork4.howManyElementInRange(testArray, -6, 8);
        System.out.println("**Test Case 6**");
        System.out.println("**How many element in given valid range:**");
        System.out.println(result);
        System.out.println();
        System.out.println("**Test Case 7**");
        System.out.println("**How many element in given ranges are bigger than array:**");
        result = HomeWork4.howManyElementInRange(testArray, 99, 200);
        System.out.println(result);
        System.out.println();
        System.out.println("**Test Case 8**");
        System.out.println("**How many element in given ranges are smaller than array:**");
        result = HomeWork4.howManyElementInRange(testArray, -200, -100);
        System.out.println(result);
        System.out.println();
        int[] testArray2 = {9, 4, 20, 3, 10, 5};
        System.out.println("**Test Case 9**");
        System.out.println("**How many sum value contains in given array:**");
        HomeWork4.isSumOfArrayEqualsOfGivenIntegerValue(testArray2, 33);
        System.out.println();
        System.out.println("**Test Case 10**");
        System.out.println("**How many sum value contains in given array (unexist sum value):**");
        System.out.println(HomeWork4.isSumOfArrayEqualsOfGivenIntegerValue(testArray2, -10));
        int[] q3testArray2 = {10, 10, 20, 1, 9, 5, 5, 4, 6, 10, 20, 3, 10, 5};
        System.out.println();
        System.out.println("**Test Case 11**");
        System.out.println("**How many sum value contains in given array:**");
        HomeWork4.isSumOfArrayEqualsOfGivenIntegerValue(q3testArray2, 20);
        System.out.println();
        System.out.println("**Test Case 12**");
        System.out.println("Fill 5 size array, 'E' represents the Empty Blocks '*' represents the filled blocks.\n");
        char[] fillerArrayTest = new char[5];
        fillerArrayTest = new char[]{'E', 'E', 'E', 'E', 'E'};
        HomeWork4.fillThisArray(fillerArrayTest);
        System.out.println();
        System.out.println("**Test Case 13**");
        System.out.println("Trying to fill 2 size array");
        char[] fillerArrayTest2 = {'E', 'E'};
        HomeWork4.fillThisArray(fillerArrayTest2);
        System.out.println();
        System.out.println("**Test Case 14*");
        System.out.println("Fill 7 size array, 'E' represents the Empty Blocks '*' represents the filled blocks.\n");
        char[] fillerArrayTest3 = {'E', 'E', 'E', 'E', 'E', 'E', 'E'};
        HomeWork4.fillThisArray(fillerArrayTest3);
        System.out.println();
        System.out.println("**Test Case 15*");
        System.out.println("Fill 9 size array, 'E' represents the Empty Blocks '*' represents the filled blocks.\n");
        char[] fillerArrayTest4 = {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'};
        HomeWork4.fillThisArray(fillerArrayTest4);
        System.out.println("**Test Case 16*");
        System.out.println("Fill the 3 size snake to 3x3 Array");
        HomeWork4.possiblePos(new int[3][3], 3);
        System.out.println("**Test Case 17*");
        System.out.println("Fill the 4 size snake to 4x4 Array");
        int[][] snakeArray = new int[4][4];
        HomeWork4.possiblePos(snakeArray, 4);
        //System.out.println(q1.isContainString(test2,test1,1));


        //q1.isSumOfArrayEqualsOfGivenIntegerValue(testArray,-10);


        char[] testArray3 = new char[8];
        //q1.isSumOfArrayEqualsOfGivenIntegerValue(testArray2,33);
        //q1.fillThisArray(testArray3,3);


    }
}
