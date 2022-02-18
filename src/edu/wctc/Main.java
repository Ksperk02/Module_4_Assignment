package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static PaintCalculator paintCalculator = new PaintCalculator();

    private static void printMenu() {
        System.out.println("""
                1. Add room 
                2. Write rooms to file 
                3. Read rooms from file
                4. View rooms 
                5. Exit""");
        System.out.print("Enter Selection: ");
    }

    private static double promptForDimension(String dimensionName) {

        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Enter the room's " + dimensionName + ": ");
        return keyBoard.nextDouble();
    }

    private static void createRoom() {
        double length, width, height;
        length = promptForDimension("length");
        width = promptForDimension("width");
        height = promptForDimension("height");
        paintCalculator.addRoom(length, width, height);
        System.out.println("Room successfully created");
        System.out.println(" ");
    }

    private static void readFile() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("module4.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        paintCalculator = (PaintCalculator) ois.readObject();
        System.out.println("File read successfully ");
        System.out.println(" ");
        ois.close();
    }

    private static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("module4.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(paintCalculator);
        System.out.println("File written successfully ");
        System.out.println(" ");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner keyBoard = new Scanner(System.in);
        int selection;
        do {
            printMenu();
            selection = keyBoard.nextInt();
            switch (selection) {
                case 1 -> createRoom();
                case 2 -> writeFile();
                case 3 -> readFile();
                case 4 -> System.out.println(paintCalculator.toString());
                case 5 -> System.out.println("Goodbye");
            }
        }
        while (selection != 5);
    }
}