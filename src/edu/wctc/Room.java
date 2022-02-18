package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList = new ArrayList<>();

    private double width;
    private double height;
    private double length;


    public Room (double width,double length, double height){
        this.width = width;
        this.height = height;
        this.length = length;

        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width,height);
        Wall wall3 = new Wall(length,height);
        Wall wall4 = new Wall(length,height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea(){
        double wall1 = (length*height)*2;
        double wall2 = (width*height)*2;
        double area = wall1 + wall2;

        return area;
    }
    public  String toString(){
        return ("Room with area: " + getArea());
    }
}