package org.dmdev.natalliavasilyeva.oop.model;

import org.dmdev.natalliavasilyeva.oop.interfaces.Printable;

import java.util.Objects;

public class Room implements Printable {
    private final boolean isWalkableRoom;

    public Room(boolean isPassageRoom) {
        this.isWalkableRoom = isPassageRoom;
    }

    public boolean isWalkableRoom() {
        return isWalkableRoom;
    }

    @Override
    public void print() {
        if (isWalkableRoom) {
            System.out.printf("Room is walkable%n");
        } else {
            System.out.printf("Room is non walkable%n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isWalkableRoom == room.isWalkableRoom();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWalkableRoom);
    }

    @Override
    public String toString() {
        return "Room{" +
                "isPassageRoom=" + isWalkableRoom +
                '}';
    }
}