package com.HomeWork4;

import java.util.ArrayList;

public class myHw4Class {


    static ArrayList<int[][]> list = new ArrayList<>();
    static int res = 0;
    ArrayList<Integer> occurenceIndexArrayList = new ArrayList<Integer>();

    static boolean isHave(int[][] matrix) {

        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (list.get(i)[j][k] != matrix[j][k]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) return true;
        }

        return false;

    }

    private static int[][] copyArr(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {

                res[j][k] = matrix[j][k];
            }
        }

        return res;
    }

    private static void possiblePos(int[][] matrix, int length, int left, int snakeNum, int i, int j) {
        if (left == 0) {
            res++;
            if (!isHave(matrix)) {//Θ(n^2)
                //print statt
                for (int z = 0; z < length; z++) {//Θ(n)
                    for (int k = 0; k < length; k++) {//Θ(n^2)
                        System.out.print(matrix[z][k] + " ");//Θ(1)

                    }
                    System.out.println();//Θ(1)

                }
                System.out.println();//Θ(1)
                System.out.println();//Θ(1)
                System.out.println();//Θ(1)
            }
            list.add(copyArr(matrix));//Θ(1)

        }
        if (j < 0 || i < 0 || i >= length || j >= length || matrix[i][j] != 0) return;//Θ(1)

        matrix[i][j] = snakeNum;//Θ(1)
        left--;//Θ(1)
        if (left % length == 0) snakeNum++;//Θ(1)

        possiblePos(matrix, length, left, snakeNum, i + 1, j);//Θ(n^3)
        possiblePos(matrix, length, left, snakeNum, i - 1, j);//Θ(n^3)
        possiblePos(matrix, length, left, snakeNum, i, j + 1);//Θ(n^3)
        possiblePos(matrix, length, left, snakeNum, i, j - 1);//Θ(n^3)

        matrix[i][j] = 0;//Θ(1)

        list.clear();//Θ(n)
    }

    public int isContainString(String smallString, String bigString, int indexOfIthOccurence) {
        this.isContainStringRecur(smallString, bigString, 0); //Θ(n^4)
        if (smallString.length() > bigString.length()) {//Θ(1)
            System.out.println("Your first string must be smaller or equal than the second one!");//Θ(1)
            return -1;//Θ(1)
        } else {
        }

        if (occurenceIndexArrayList.size() < indexOfIthOccurence || indexOfIthOccurence <= 0) {//Θ(1)
            System.out.println("You are looking for unexist occurence");//Θ(1)
            return -1;
        } else {
            return occurenceIndexArrayList.get(indexOfIthOccurence - 1);//Θ(1)
        }
    }

    private int isContainStringRecur(String smallString, String bigString, int index) {
        ArrayList<Character> smallStringToCharArrayList = new ArrayList<Character>();
        for (char c : smallString.toCharArray()) { // Θ(n^2) toCharArray takes O(n), when loop total is Θ(n^2)
            smallStringToCharArrayList.add(c);
        }
        ArrayList<Character> bigStringToCharArrayList = new ArrayList<Character>();
        for (char c : bigString.toCharArray()) {
            bigStringToCharArrayList.add(c);
        }

        int corrector = 0;
        for (int j = 0; j < smallString.length(); j++) {//O(n)
            if (bigString.length() < smallString.length()) {
                return -1;
            }//O(1)
            if (smallStringToCharArrayList.get(j) == bigStringToCharArrayList.get(j)) { //O(1)
                corrector++;//O(1)
            }
            if (corrector == smallString.length()) {//O(1)
                occurenceIndexArrayList.add(index);//O(1)
                break;//O(1)
            }

        }

        return isContainStringRecur(smallString, bigString.substring(1), index + 1);//T(n) = T(n-1) + Θ(n^3) because of Strings are immutable.
    }

    public int howManyElementInRange(int[] givenArray, int lowerBound, int upperBound) {
        if (givenArray.length == 0 || givenArray == null) {
            return 0;//Θ(1)
        }
        if (givenArray[0] <= lowerBound) {//Θ(1)
            int size = givenArray.length;//Θ(1)
            int[] newArray = new int[size - 1];//Θ(1)
            for (int i = 1, k = 0; i < size; i++) {//Θ(n)
                newArray[k] = givenArray[i];//Θ(1)
                k++;//Θ(1)
            }
            return howManyElementInRange(newArray, lowerBound, upperBound);//Θ(n^2)
        }

        if (givenArray[givenArray.length - 1] >= upperBound) {

            int size = givenArray.length;//Θ(1)
            int[] newArray = new int[size - 1];//Θ(1)
            for (int i = size - 2; i != -1; i--) {//Θ(n)

                newArray[i] = givenArray[i];//Θ(1)

            }
            return howManyElementInRange(newArray, lowerBound, upperBound);//Θ(n^2)
        }

        return givenArray.length;//Θ(1)

    }

    public int isSumOfArrayEqualsOfGivenIntegerValue(int[] givenArray, int sumValue) {
        if (givenArray.length == 0) {
            return 0;
        }//Θ(1)
        int sumOfArrayElems = 0;//Θ(1)
        for (int i = 0; i < givenArray.length; i++) {//Θ(n)
            sumOfArrayElems += givenArray[i];//Θ(1)
            if (sumOfArrayElems == sumValue) {
                System.out.print("We found some array that satisfy the condition: ");//Θ(1)
                for (int k = 0; k < i + 1; k++) {//Θ(n^2)
                    System.out.print(givenArray[k] + " ");//Θ(1)
                }
                System.out.println();//Θ(1)
            }
        }
        int size = givenArray.length;//Θ(1)
        int[] newArray = new int[size - 1];//Θ(1)
        for (int i = 1, k = 0; i < size; i++) {//Θ(n)
            newArray[k] = givenArray[i];//Θ(1)
            k++;//Θ(1)
        }

        return isSumOfArrayEqualsOfGivenIntegerValue(newArray, sumValue);//Θ(n^3)

    }

    public void fillThisArray(char[] givenArray) {
        this.fillThisArray(givenArray, 3);
    }

    private int fillThisArray(char[] givenArray, int k) {
        if (givenArray.length < 3) {//Θ(1)
            System.out.println("The given array size can not less than 3!");//Θ(1)
            return -1;//Θ(1)
        }
        if (k > givenArray.length) {//Θ(1)
            System.out.println("FINISH!");//Θ(1)
            return 1;//Θ(1)
        }

        for (int i = 0; i < givenArray.length - k + 1; i++) {//Θ(n)
            for (int j = 0; j < k; j++) {//Θ(n^2)
                givenArray[i + j] = '*';//Θ(1)
            }
            for (int q = 0; q < givenArray.length; q++) {//Θ(n^2)
                System.out.print(givenArray[q] + " ");//Θ(1)
            }
            System.out.println();
            for (int q = 0; q < givenArray.length; q++) {//Θ(n^2)
                givenArray[q] = 'E';//Θ(1)
            }
        }

        if (givenArray.length / k > 1) {
            for (int i = 0; i < givenArray.length - k + 1; i++) {//Θ(n)
                for (int q = 0; q < k; q++) {//Θ(n^2)
                    givenArray[i + q] = '*';//Θ(1)
                }
                for (int j = i + k + 1; j < givenArray.length - k + 1; j++) {//Θ(n^2)
                    for (int p = 0; p < k; p++) {//Θ(n^3)
                        givenArray[j + p] = '*';//Θ(1)
                    }

                    for (int l = 0; l < givenArray.length; l++) {//Θ(n^3)
                        System.out.print(givenArray[l] + " ");
                    }
                    System.out.println();
                    for (int m = i + k + 1; m < givenArray.length; m++) {//Θ(n^3)
                        givenArray[m] = 'E';//Θ(1)
                    }

                }
                for (int m = 0; m < givenArray.length; m++) {//Θ(n^3)
                    givenArray[m] = 'E';//Θ(1)
                }
            }
        }

        for (int m = 0; m < givenArray.length; m++) {
            givenArray[m] = 'E';
        }
        System.out.println();
        return fillThisArray(givenArray, k + 1);//Θ(n^4)
    }

    public void possiblePos(int[][] matrix, int snakeLength) {
        possiblePos(matrix, snakeLength, snakeLength * snakeLength, 1, 0, 0);//Θ(n^3)
    }


    }
