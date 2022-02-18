package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private final List<Room> roomList = new ArrayList<>();

    public void addRoom(double width, double length, double height) {
        roomList.add(new Room(width, length, height));
    }

    public String toString() {
        if (roomList.isEmpty()) {
            return "Nothing yet, hombre.";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Room room : roomList) {
                stringBuilder.append("Room ").append(roomList.indexOf(room) + 1);
                stringBuilder.append(" has an area of ").append(room.getArea()).append("\n");
            }
            return stringBuilder.toString();
        }
    }
}