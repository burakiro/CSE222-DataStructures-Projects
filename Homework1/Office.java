package com.HW1;
/**
 *
 * Office Class
 */
public class Office implements Building {
    public Office() {
        Owner = "Default";
        JobType = "Default";
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String focus() {
        return this.getJobType();
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

    private String Owner;
    private String JobType;
    private int length;
    private int position;
    private int height;
}
