package org.dmdev.natalliavasilyeva.streams.utils;

import org.dmdev.natalliavasilyeva.streams.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public final class StudentUtils {

    private StudentUtils() {
    }

    public static Map<Integer, Double> getAverageMarksOnCourse(List<Student> students) {
        return students
                .stream()
                .filter(student -> student.getMarks().size() > 3)
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        Collectors.averagingDouble(Student::getAverageMark)));

    }

    public static Map<Integer, List<String>> getStudentsFullNameOnCourse(List<Student> students) {
        return students
                .stream()
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        mapping(Student::getFullName,
                                Collectors.collectingAndThen(toList(),
                                        (l -> l.stream()
                                                .sorted()
                                                .collect(toList()))))));


    }

    public static Map<Integer, Map<Double, List<String>>> getStudentsFullNameWithAverageMarkOnCourse(List<Student> students) {
        return students
                .stream()
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        groupingBy(Student::getAverageMark,
                                TreeMap::new,
                                mapping(Student::getFullName,
                                        Collectors.collectingAndThen(toList(),
                                                (l -> l.stream()
                                                        .sorted()
                                                        .collect(toList())))))));
    }

}