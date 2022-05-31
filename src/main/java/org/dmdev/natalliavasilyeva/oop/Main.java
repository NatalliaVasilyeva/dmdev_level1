package org.dmdev.natalliavasilyeva.oop;

import org.dmdev.natalliavasilyeva.oop.model.Flat;
import org.dmdev.natalliavasilyeva.oop.model.Floor;
import org.dmdev.natalliavasilyeva.oop.model.House;
import org.dmdev.natalliavasilyeva.oop.model.Room;
/*
Represent the following model in the form of classes and their composition.
- Each house contains its own number (int) and a set of floors (array).
- Each floor contains a floor number (int) and a set of apartments (array).
- Each apartment contains its own number (int) and a set of rooms (array).
- Each room contains a field whether it is walkable or not (boolean).
Implement the print method, which prints information about the object to the console
 (all fields of the object must be present!) in each class.
For example, the print method in the floor class should output to the console:
“Floor 2, number of apartments 18”
Move the creation of all objects into a separate class with the main method.
Implement the printAllInformation method, which takes an object
of the house type and displays information about it, its floors, apartments,
and rooms by calling the print methods.
 */

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(false);
        Room room2 = new Room(true);
        Flat flat1 = new Flat(1, new Room[]{room1, room2});
        Flat flat2 = new Flat(2, new Room[]{room1});
        Floor floor1 = new Floor(1, new Flat[]{flat1, flat2});
        Floor floor2 = new Floor(2, new Flat[]{flat1});
        House house1 = new House(1, new Floor[]{floor1, floor2});

        printAllInformation(house1);
    }

    public static void printAllInformation(House house) {
        house.print();
        for (Floor floor : house.getFloors()) {
            floor.print();
            for (Flat flat : floor.getFlats()) {
                flat.print();
                for (Room room : flat.getRooms()) {
                    room.print();
                }
            }
        }
    }
}