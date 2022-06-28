package com.arrayListStreet;
/**
 *
 * House Class
 */
public class House implements Building{
    public House() {
        Owner = "Default";
        NumberOfRooms = 0;
        Color = "Default";
    }

    private int NumberOfRooms;

    public int getNumberOfRooms() {
        return NumberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        NumberOfRooms = numberOfRooms;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String focus() {
        return getOwner();
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

    private String Color;
    private String Owner;
    private int length;
    private int position;
    private int height;
}
