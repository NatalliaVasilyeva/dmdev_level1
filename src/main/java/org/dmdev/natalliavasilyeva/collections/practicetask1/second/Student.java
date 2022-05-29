package org.dmdev.natalliavasilyeva.collections.practicetask1.second;

import java.util.Objects;

public class Student {

    private final String name;
    private final int age;
    private final double averageMark;

    public Student(String name, int age, double averageMark) {
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.averageMark, averageMark) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, averageMark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", averageMark=" + averageMark +
                '}';
    }
}