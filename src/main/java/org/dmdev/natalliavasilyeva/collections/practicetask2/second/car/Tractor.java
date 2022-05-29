package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

import java.util.Objects;

public class Tractor extends Car {

    Equipment equipment;

    public Tractor(Brand brand, Model model, int year, Color color, Equipment equipment) {
        super(brand, model, year, color);
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tractor tractor = (Tractor) o;
        return equipment == tractor.equipment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipment);
    }

    @Override
    public String toString() {
        return "Tractor{" +
                "equipment=" + equipment +
                '}' + super.toString();
    }
}