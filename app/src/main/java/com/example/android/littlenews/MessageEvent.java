package com.example.android.littlenews;

public class MessageEvent{
    private int secNumber;
    private int navNumber;
    MessageEvent(int navNumber, int secNumber){
        this.secNumber = secNumber;
        this.navNumber = navNumber;
    }
 
    public int getsecNumber() {
        return secNumber;
    }
 
    public void setsecNumber(int sectionNumber) {
        this.secNumber = sectionNumber;
    }

    public int getnavNumber() {
        return navNumber;
    }

    public void setnavNumber(int navNumber) {
        this.navNumber = navNumber;
    }
}