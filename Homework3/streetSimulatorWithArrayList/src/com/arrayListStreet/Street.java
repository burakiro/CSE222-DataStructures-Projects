package com.arrayListStreet;

import java.util.ArrayList;
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
    public ArrayList<Building> streetArray = new ArrayList<Building>();
    //public Building [] streetArray = new Building[999];//Default 999 Position slot for builds.

    /**
     *
     * Add method
     */
    public void add(Building build){
        if(this.currentLength + build.getLength() > totalLength || this.currentLength == totalLength || build.getLength() > this.totalLength){//O(1)
            System.out.println("There is not enough space for add a new build.");//O(1)
        }
        else{
        streetArray.add(build);//O(1)
        //streetArray[buildingsLastIndex] = build;
        currentLength += build.getLength();//O(1)
        //buildingsLastIndex++;
        buildingsNumber++;//O(1)
        }}

    /**
     *
     * Add by Index
     */
    public void addByIndex(int i, Building build){
        if(this.currentLength + build.getLength() > totalLength || this.currentLength == totalLength || build.getLength() > this.totalLength){//O(1)
            System.out.println("There is not enough space for add a new build.");//O(1)
        }
        else{
            if(i< streetArray.size()){ // //O(N)
                streetArray.add(i,build); //O(N)
                //streetArray[i] = build;
                currentLength += build.getLength();// //O(1)
                //buildingsLastIndex++;
                buildingsNumber++; //O(1)
            }
            else{
                streetArray.add(build);//O(1)
                //streetArray[i] = build;
                currentLength += build.getLength();//O(1)
                //buildingsLastIndex++;
                buildingsNumber++;//O(1)
            }

        }
    }

    /**
     *
     * Display remaining length method
     */
    public void displayRemainingLength(){
        if(currentLength >= totalLength){//O(1)
            System.out.println("There is no space. This street is full of capacity!");//O(1)
        }
        else{
        System.out.println("The remainig length of lands on the street is " + (totalLength - currentLength) + " meter." );//O(1)
    }}

    /**
     *
     * Delete build method
     */
    public void delete(int Index){
        if(streetArray.get(Index) == null){//O(1)
            System.out.println("The building that you try to delete is not exist! Please enter a valid Index/Position!");//O(1)
        }
        else{
            currentLength -= streetArray.get(Index).getLength();//O(1)
            streetArray.remove(Index);//O(N)
            //streetArray[Index] = null;
            buildingsNumber--;//O(1)
        }
    }

    /**
     *
     * Display building method
     */
    public void displayBuildings(){
        String classname;
        if(buildingsNumber == 0 ){//O(1)
            System.out.println("There is no build in this street! ");//O(1)
        }
        else{
            for(int i=0; i<streetArray.size(); i++){//O(N)
                if(streetArray.get(i) != null ){//O(1)
                    classname = streetArray.get(i).getClass().getSimpleName();//O(1)
                    System.out.println("Slot: " + i + " Type: " + classname + " Length: " + streetArray.get(i).getLength());//O(1)
                }
            }
        }

    }

    /**
     *
     * Display total length of Specific building method
     */
    public void totalLengthOfSpecificBuildings(){
        int lengthCounter = 0;//O(1)
        String buildType;//O(1)
        if(buildingsNumber == 0){//O(1)
            System.out.println("There is no building in this street");//O(1)
        }
        else{
            System.out.println("Please enter name of building to calculate total length with case sensitive (Office, House, Market): ");//O(1)
            Scanner sc = new Scanner(System.in);//O(1)
            String classname;//O(1)
            buildType = sc.nextLine();//O(1)
            switch(buildType){//O(1)
                case "Office"://O(1)
                    for(int i=0; i<streetArray.size(); i++){//O(N)
                        if(streetArray.get(i) != null){//O(1)
                        classname = streetArray.get(i).getClass().getSimpleName();//O(1)
                            if(classname.equals("Office")){//O(1)
                                lengthCounter += streetArray.get(i).getLength();//O(1)
                            }
                        }

                    }
            System.out.println("Total length of Offices in this street is: " + lengthCounter);//O(1)
                break;//O(1)

                case "House"://O(1)

                    for(int i=0; i<streetArray.size(); i++){//O(N)
                        if(streetArray.get(i) != null){//O(1)
                            classname = streetArray.get(i).getClass().getSimpleName();//O(1)
                            if(classname.equals("House")){//O(1)
                                lengthCounter += streetArray.get(i).getLength();//O(1)
                            }
                        }
                        else
                            continue;//O(1)

                    }
                    System.out.println("Total length of Houses in this street is: " + lengthCounter);//O(1)
                    break;

                case "Market":

                    for(int i=0; i<streetArray.size(); i++){//O(N)
                        if(streetArray.get(i) != null){//O(1)
                            classname = streetArray.get(i).getClass().getSimpleName();//O(1)
                            if(classname.equals("Market")){//O(1)
                                lengthCounter += streetArray.get(i).getLength();//O(1)
                            }
                        }
                        else
                            continue;

                    }
                    System.out.println("Total length of Markets in this street is: " + lengthCounter);//O(1)
                    break;
            }

        }
    }

    /**
     *
     * Display number and Ratio of Playground method
     */
    public void displayNumberAndRationOfPlaygrounds(){
        float lengthCounter = 0; int numberOfPlayground =0;//O(1)
        String classname; float ratio;//O(1)
        for(int i=0; i<streetArray.size(); i++){//O(N)
            if(streetArray.get(i) != null){//O(1)
                classname = streetArray.get(i).getClass().getSimpleName();//O(1)
                if(classname.equals("Playground")){//O(1)
                    lengthCounter += streetArray.get(i).getLength();//O(1)
                    numberOfPlayground++;//O(1)
                }
            }
        }
        ratio = lengthCounter/this.totalLength;//O(1)
        System.out.println("Total Playgrounds Number: " + numberOfPlayground + " Ratio of Playgrounds: " + ratio);//O(1)
    }

    /**
     *
     * Display Skyline Silhouette method
     */
    public void displaySkylineSilhouette(){
        int maxHeight = 0;
        int maxWidth = 0;

        for(int i = 0;i<streetArray.size();i++){//O(N)
            maxHeight = maxHeight > streetArray.get(i).getHeight() ? maxHeight : streetArray.get(i).getHeight();//O(1)
            maxWidth = maxWidth > streetArray.get(i).getLength() + streetArray.get(i).getPosition() ? maxWidth : streetArray.get(i).getLength() + streetArray.get(i).getPosition();//O(1)
        }

        //int [] totalHeights = new int[maxWidth];
        ArrayList <Integer> totalHeights = new ArrayList<Integer>();//O(1)
        for(int i=0;i<maxWidth;i++){//O(N)
            totalHeights.add(i,0);//O(1)
        }

        for(int i = 0 ;i<streetArray.size();i++){//O(N)
            for(int j = streetArray.get(i).getPosition();j<streetArray.get(i).getPosition()+streetArray.get(i).getLength();j++){//O(N)
                    totalHeights.set(j, totalHeights.get(j) > streetArray.get(i).getHeight() ? totalHeights.get(j) : streetArray.get(i).getHeight());//O(1)
            }
        }
        /*System.out.println(totalHeights.size());
        for(int i = 0 ; i< totalHeights.size();i++){
            System.out.println(i);
            System.out.print(totalHeights.get(i) + " ");
        }
        System.out.println();*/

        for(int i = 0;i<maxHeight;i++){//O(N)
            for(int j = 0;j<maxWidth;j++){//O(N)
                if(maxHeight - i > totalHeights.get(j)){//O(1)
                    System.out.print(' ');//O(1)
                }
                else
                    System.out.print('#');//O(1)
            }
            System.out.println();//O(1)
        }


    }

}
