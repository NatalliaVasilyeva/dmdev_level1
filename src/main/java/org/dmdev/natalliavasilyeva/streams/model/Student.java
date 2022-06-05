package org.dmdev.natalliavasilyeva.streams.model;

import java.util.List;
import java.util.Objects;

public class Student {

    private final String name;
    private final String surname;
    private final int course;
    private final List<Mark> marks;

    public Student(String name, String surname, int course, List<Mark> marks) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public double getAverageMark() {
        return marks.stream().mapToDouble(Mark::getValue).average().orElse(0.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getCourse() == student.course && Objects.equals(getName(), student.name) && Objects.equals(getSurname(), student.surname) && Objects.equals(getMarks(), student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getCourse(), getMarks());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", course=" + getCourse() +
                ", marks=" + getMarks() +
                '}';
    }
}