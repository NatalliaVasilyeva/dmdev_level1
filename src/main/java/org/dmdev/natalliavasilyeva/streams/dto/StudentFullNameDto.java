package org.dmdev.natalliavasilyeva.streams.dto;

public class StudentFullNameDto {

    private final String name;

    private final String surname;

    public StudentFullNameDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student with full name is " +
                getName() + ' ' + getSurname();
    }
}