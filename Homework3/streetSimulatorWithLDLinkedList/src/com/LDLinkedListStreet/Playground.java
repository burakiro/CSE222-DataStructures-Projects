package com.LDLinkedListStreet;
/**
 *
 * Playground Class
 */
public class Playground implements Building {

    public Playground() {
        height = 5; // Default Playground Height
    }

    public int getLength() {
        return length;
    }

    public String focus() {
         return String.valueOf(this.getLength());
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



    private int length;
    private int position;
    private int height;
}
