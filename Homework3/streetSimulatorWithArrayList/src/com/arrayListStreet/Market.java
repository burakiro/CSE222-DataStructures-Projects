package com.arrayListStreet;
/**
 *
 * Market Class
 */
public class Market implements Building {

    Market(){
        Owner = "Default";
        OpeningTime=0000;
        ClosingTime=0000;
    }

    private String Owner;

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getOpeningTime() {
        return OpeningTime;
    }

    public void setOpeningTime(int openingTime) {
        OpeningTime = openingTime;
    }

    public int getClosingTime() {
        return ClosingTime;
    }

    public void setClosingTime(int closingTime) {
        ClosingTime = closingTime;
    }

    public int getLength() {
        return length;
    }


    public String focus() {
        return String.valueOf(this.getClosingTime());
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    private int OpeningTime;
    private int ClosingTime;
    private int length;
    private int position;
    private int height;
}
