package com.HW1;

import java.util.Scanner;
/**
 *
 * Street Class
 */
public class Street {
    public Street() {
        this.settotalLength();
    }
    public int gettotalLength() {
        return totalLength;
    }
    public void settotalLength() {
        System.out.println("Please enter length of Street:");
        Scanner sc=new Scanner(System.in);
        totalLength = sc.nextInt();
    }
    private int buildingsNumber = 0;
    private int buildingsLastIndex = 0;
    private int totalLength;
    private int currentLength = 0;
    public Building [] streetArray = new Building[999];//Default 999 Position slot for builds.

    /**
     *
     * Add method
     */
    public void add(Building build){
        if(this.currentLength + build.getLength() > totalLength || this.currentLength == totalLength || build.getLength() > this.totalLength){
            System.out.println("There is not enough space for add a new build.");
        }
        else{
        streetArray[buildingsLastIndex] = build;
        currentLength += build.getLength();
        buildingsLastIndex++;
        buildingsNumber++;
        }}

    /**
     *
     * Add by Index
     */
    public void addByIndex(int i, Building build){
        if(this.currentLength + build.getLength() > totalLength || this.currentLength == totalLength || build.getLength() > this.totalLength){
            System.out.println("There is not enough space for add a new build.");
        }
        else{
            streetArray[i] = build;
            currentLength += build.getLength();
            buildingsLastIndex++;
            buildingsNumber++;
        }
    }

    /**
     *
     * Display remaining length method
     */
    public void displayRemainingLength(){
        if(currentLength >= totalLength){
            System.out.println("There is no space. This street is full of capacity!");
        }
        else{
        System.out.println("The remainig length of lands on the street is " + (totalLength - currentLength) + " meter." );
    }}

    /**
     *
     * Delete build method
     */
    public void delete(int Index){
        if(streetArray[Index] == null){
            System.out.println("The building that you try to delete is not exist! Please enter a valid Index/Position!");
        }
        else{
            currentLength -= streetArray[Index].getLength();
            streetArray[Index] = null;
            buildingsNumber--;
        }
    }

    /**
     *
     * Display building method
     */
    public void displayBuildings(){
        String classname;
        if(buildingsNumber == 0 ){
            System.out.println("There is no build in this street! ");
        }
        else{
            for(int i=0; i<=buildingsLastIndex; i++){
                if(streetArray[i] != null ){
                    classname = streetArray[i].getClass().getSimpleName();
                    System.out.println("Slot: " + i + " Type: " + classname + " Length: " + streetArray[i].getLength());
                }
            }
        }

    }

    /**
     *
     * Display total length of Specific building method
     */
    public void totalLengthOfSpecificBuildings(){
        int lengthCounter = 0;
        String buildType;
        if(buildingsNumber == 0){
            System.out.println("There is no building in this street");
        }
        else{
            System.out.println("Please enter name of building to calculate total length with case sensitive (Office, House, Market): ");
            Scanner sc = new Scanner(System.in);
            String classname;
            buildType = sc.nextLine();
            switch(buildType){
                case "Office":
                    for(int i=0; i<=buildingsLastIndex; i++){
                        if(streetArray[i] != null){
                        classname = streetArray[i].getClass().getSimpleName();
                            if(classname.equals("Office")){
                                lengthCounter += streetArray[i].getLength();
                            }
                        }

                    }
            System.out.println("Total length of Offices in this street is: " + lengthCounter);
                break;

                case "House":

                    for(int i=0; i<=buildingsLastIndex; i++){
                        if(streetArray[i] != null){
                            classname = streetArray[i].getClass().getSimpleName();
                            if(classname.equals("House")){
                                lengthCounter += streetArray[i].getLength();
                            }
                        }
                        else
                            continue;

                    }
                    System.out.println("Total length of Houses in this street is: " + lengthCounter);
                    break;

                case "Market":

                    for(int i=0; i<=buildingsLastIndex; i++){
                        if(streetArray[i] != null){
                            classname = streetArray[i].getClass().getSimpleName();
                            if(classname.equals("Market")){
                                lengthCounter += streetArray[i].getLength();
                            }
                        }
                        else
                            continue;

                    }
                    System.out.println("Total length of Markets in this street is: " + lengthCounter);
                    break;
            }

        }
    }

    /**
     *
     * Display number and Ratio of Playground method
     */
    public void displayNumberAndRationOfPlaygrounds(){
        float lengthCounter = 0; int numberOfPlayground =0;
        String classname; float ratio;
        for(int i=0; i<=buildingsLastIndex; i++){
            if(streetArray[i] != null){
                classname = streetArray[i].getClass().getSimpleName();
                if(classname.equals("Playground")){
                    lengthCounter += streetArray[i].getLength();
                    numberOfPlayground++;
                }
            }
        }
        ratio = lengthCounter/this.totalLength;
        System.out.println("Total Playgrounds Number: " + numberOfPlayground + " Ratio of Playgrounds: " + ratio);
    }

    /**
     *
     * Display Skyline Silhouette method
     */
    public void displaySkylineSilhouette(){
        int maxHeight = 0;
        int maxWidth = 0;

        for(int i = 0;i<buildingsLastIndex;i++){
            maxHeight = maxHeight > streetArray[i].getHeight() ? maxHeight : streetArray[i].getHeight();
            maxWidth = maxWidth > streetArray[i].getLength() + streetArray[i].getPosition() ? maxWidth : streetArray[i].getLength() + streetArray[i].getPosition();
        }

        int [] totalHeights = new int[maxWidth];

        for(int i = 0 ;i<buildingsLastIndex;i++){
            for(int j = streetArray[i].getPosition();j<streetArray[i].getPosition()+streetArray[i].getLength();j++){
                totalHeights[j] = totalHeights[j] > streetArray[i].getHeight() ? totalHeights[j] : streetArray[i].getHeight();
            }
        }
        //System.out.println(maxHeight);
        /*for(int i = 0 ; i< maxWidth;i++){
            System.out.print(totalHeights[i] + " ");
        }
        System.out.println();*/

        for(int i = 0;i<maxHeight;i++){
            for(int j = 0;j<maxWidth;j++){
                if(maxHeight - i > totalHeights[j]){
                    System.out.print(' ');
                }
                else
                    System.out.print('#');
            }
            System.out.println();
        }


    }

}
