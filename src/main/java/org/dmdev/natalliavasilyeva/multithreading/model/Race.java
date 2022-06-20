package org.dmdev.natalliavasilyeva.multithreading.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Race {

    private final Map<Color, Integer> crystals = new EnumMap<>(Color.class);
    private final String name;

    public Race(String name) {
        this.name = name;
    }

    public void addCrystals(List<Crystal> list) {
        list.forEach(crystal -> {
            if (crystals.isEmpty() || crystals.get(crystal.getColor()) == null) {
                crystals.put(crystal.getColor(), 1);
            } else {
                crystals.put(crystal.getColor(), crystals.get(crystal.getColor()) + 1);
            }
        });
    }

    public boolean isFull() {
        Optional<Integer> crystalCount = crystals.values().stream().min(Integer::compareTo);
        return checkResult(crystalCount.orElse(0));
    }

    private boolean checkResult(Integer numberOfCrystals) {
        return numberOfCrystals >= 500;
    }

    public String getName() {
        return name;
    }

}