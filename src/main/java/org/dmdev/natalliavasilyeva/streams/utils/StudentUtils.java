package org.dmdev.natalliavasilyeva.streams.utils;

import org.dmdev.natalliavasilyeva.streams.dto.StudentFullNameAndAverageMarkDto;
import org.dmdev.natalliavasilyeva.streams.dto.StudentFullNameDto;
import org.dmdev.natalliavasilyeva.streams.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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

    public static Map<Integer, List<StudentFullNameDto>> getStudentsFullNameOnCourseWithMapping(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getName).thenComparing(Student::getSurname))
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        mapping(student -> new StudentFullNameDto(student.getName(), student.getSurname()),
                                Collectors.toList())));
    }

    public static Map<Integer, List<StudentFullNameDto>> getStudentsFullNameOnCourseWithCollectingAndThen(List<Student> students) {
        return students
                .stream()
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        collectingAndThen(toList(), list ->
                                list
                                        .stream()
                                        .map(s -> new StudentFullNameDto(s.getName(), s.getSurname()))
                                        .sorted(Comparator.comparing(StudentFullNameDto::getName).thenComparing(StudentFullNameDto::getSurname))
                                        .collect(toList()))));
    }

    public static Map<Integer, StudentFullNameAndAverageMarkDto> getStudentsFullNameWithAverageMarkOnCourse(List<Student> students) {
        return students
                .stream()
                .collect(groupingBy(Student::getCourse,
                        TreeMap::new,
                        collectingAndThen(toList(), list -> {
                            List<StudentFullNameDto> studentFullNameList = list
                                    .stream()
                                    .map(s -> new StudentFullNameDto(s.getName(), s.getSurname()))
                                    .sorted(Comparator.comparing(StudentFullNameDto::getName).thenComparing(StudentFullNameDto::getSurname))
                                    .collect(toList());

                            double averageMark = list.stream()
                                    .collect(averagingDouble(Student::getAverageMark));

                            return new StudentFullNameAndAverageMarkDto(studentFullNameList, averageMark);
                        })));
    }

}