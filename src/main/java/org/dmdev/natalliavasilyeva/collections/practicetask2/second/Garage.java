package org.dmdev.natalliavasilyeva.collections.practicetask2.second;

import org.dmdev.natalliavasilyeva.collections.practicetask2.second.car.Brand;
import org.dmdev.natalliavasilyeva.collections.practicetask2.second.car.Car;
import org.dmdev.natalliavasilyeva.collections.practicetask2.second.car.Color;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private final static int MAXIMUM_GARAGE_PLACE = 500;
    private int currentOccupiedPlace = 0;


    private Map<Car, Integer> cars = new HashMap<>();

    public void park(Car car) {
        if (currentOccupiedPlace < MAXIMUM_GARAGE_PLACE) {
            int numberOfThisTypeCars = cars.getOrDefault(car, 0);
            cars.put(car, numberOfThisTypeCars + 1);
            currentOccupiedPlace += 1;
        } else {
            System.out.println("Garage is full. Please find other one");
        }
    }

    public void departure(Car car) {
       int numberOfThisTypeCars = cars.getOrDefault(car, 0);
       int newNumberOfThisTypeCars = numberOfThisTypeCars == 0 ? 0 : numberOfThisTypeCars - 1;
       cars.put(car, newNumberOfThisTypeCars);
       currentOccupiedPlace = numberOfThisTypeCars == 0 ? currentOccupiedPlace : currentOccupiedPlace - 1;
    }

    public int getNumberOfCarsByBrand(Brand brand) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry: cars.entrySet()) {
            if (entry.getKey().getBrand().equals(brand)) {
                result += entry.getValue();
            }
        }
        return result;
    }

    public int getNumberOfCarsByColor(Color color) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry: cars.entrySet()) {
            if (entry.getKey().getColor().equals(color)) {
                result += entry.getValue();
            }
        }
        return result;
    }
}