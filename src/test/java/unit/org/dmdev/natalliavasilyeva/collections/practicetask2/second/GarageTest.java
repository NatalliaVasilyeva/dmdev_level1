package unit.org.dmdev.natalliavasilyeva.collections.practicetask2.second;

import org.dmdev.natalliavasilyeva.collections.practicetask2.second.Garage;
import org.dmdev.natalliavasilyeva.collections.practicetask2.second.car.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GarageTest {

    @Test
    public void garageParkTest() {
        //given
        Garage garage = new Garage();
        garage.park(new Tractor(Brand.MERCEDES, Model.CARGO,1980, Color.BLACK, Equipment.GRASSCUTTER));
        garage.park(new Tractor(Brand.BMW, Model.CARGO,2000, Color.BLACK, Equipment.TRAILER));
        garage.park(new Truck(Brand.VOLVO, Model.CARGO,2022, Color.RED, 20));
        garage.park(new Truck(Brand.MERCEDES, Model.CARGO,2021, Color.WHITE, 10));
        garage.park(new Bus(Brand.BMW, Model.MINIVAN,2022, Color.RED, 40));
        garage.park(new Bus(Brand.VOLVO, Model.MINIVAN,2020, Color.WHITE, 15));

        int expectedMercedesNumber = 2;
        int expectedRedCarNumber = 2;

        //when
        int actualMercedesNumber = garage.getNumberOfCarsByBrand(Brand.MERCEDES);
        int actualRedCarNumber = garage.getNumberOfCarsByColor(Color.RED);

        //then
        Assertions.assertEquals(expectedMercedesNumber, actualMercedesNumber);
        Assertions.assertEquals(expectedRedCarNumber, actualRedCarNumber);

    }

    @Test
    public void garageDepartureTest() {
        //given
        Garage garage = new Garage();
        garage.park(new Tractor(Brand.MERCEDES, Model.CARGO,1980, Color.BLACK, Equipment.GRASSCUTTER));
        garage.park(new Tractor(Brand.BMW, Model.CARGO,2000, Color.BLACK, Equipment.TRAILER));
        garage.park(new Truck(Brand.VOLVO, Model.CARGO,2022, Color.RED, 20));
        garage.park(new Truck(Brand.MERCEDES, Model.CARGO,2021, Color.WHITE, 10));
        garage.park(new Bus(Brand.BMW, Model.MINIVAN,2022, Color.RED, 40));
        garage.park(new Bus(Brand.VOLVO, Model.MINIVAN,2020, Color.WHITE, 15));

        int expectedMercedesNumberAfterDeparture = 1;
        int expectedRedCarNumberAfterDeparture = 1;

        //when
        garage.departure(new Tractor(Brand.MERCEDES, Model.CARGO,1980, Color.BLACK, Equipment.GRASSCUTTER));
        garage.departure(new Bus(Brand.BMW, Model.MINIVAN,2022, Color.RED, 40));

        int actualMercedesNumberAfterDeparture = garage.getNumberOfCarsByBrand(Brand.MERCEDES);
        int actualRedCarNumberAfterDeparture = garage.getNumberOfCarsByColor(Color.RED);

        //then
        Assertions.assertEquals(expectedMercedesNumberAfterDeparture, actualMercedesNumberAfterDeparture);
        Assertions.assertEquals(expectedRedCarNumberAfterDeparture, actualRedCarNumberAfterDeparture);
    }
}