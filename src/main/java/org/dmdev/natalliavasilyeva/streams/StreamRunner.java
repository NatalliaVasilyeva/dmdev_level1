package org.dmdev.natalliavasilyeva.streams;

import org.dmdev.natalliavasilyeva.streams.dto.StudentFullNameAndAverageMarkDto;
import org.dmdev.natalliavasilyeva.streams.dto.StudentFullNameDto;
import org.dmdev.natalliavasilyeva.streams.model.Student;
import org.dmdev.natalliavasilyeva.streams.utils.MarkUtils;
import org.dmdev.natalliavasilyeva.streams.utils.StudentUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class StreamRunner {
    private static final int UPPERBOUND_MARK = 11;

    public static void main(String[] args) {
        Random random = new Random();

        List<Student> students = List.of(
                new Student("Ivan", "Ivanov", 1, MarkUtils.generateMarks(4, random, UPPERBOUND_MARK)),
                new Student("Petr", "Petrov", 2, MarkUtils.generateMarks(7, random, UPPERBOUND_MARK)),
                new Student("Innokentiy", "Sidorov", 3, MarkUtils.generateMarks(2, random, UPPERBOUND_MARK)),
                new Student("Mihail", "Izmailov", 2, MarkUtils.generateMarks(1, random, UPPERBOUND_MARK)),
                new Student("Nikolai", "Golikov", 1, MarkUtils.generateMarks(7, random, UPPERBOUND_MARK)),
                new Student("Georgiy", "Popuashviliy", 5, MarkUtils.generateMarks(10, random, UPPERBOUND_MARK)),
                new Student("Dmitriy", "Dmitriev", 3, MarkUtils.generateMarks(3, random, UPPERBOUND_MARK)),
                new Student("Mihail", "Mihailov", 2, MarkUtils.generateMarks(3, random, UPPERBOUND_MARK)),
                new Student("Olga", "Bliznets", 4, MarkUtils.generateMarks(3, random, UPPERBOUND_MARK)),
                new Student("Elena", "Kozlova", 5, MarkUtils.generateMarks(4, random, UPPERBOUND_MARK))
        );

        Map<Integer, Double> averageMarksOnCourse = StudentUtils.getAverageMarksOnCourse(students);
        System.out.println(averageMarksOnCourse);

        Map<Integer, List<StudentFullNameDto>> listOfStudentsFullNameOnEachCourseWithCollectingAndThen = StudentUtils.getStudentsFullNameOnCourseWithCollectingAndThen(students);
        System.out.println(listOfStudentsFullNameOnEachCourseWithCollectingAndThen);

        Map<Integer, List<StudentFullNameDto>> listOfStudentsFullNameOnEachCourseWithMapping = StudentUtils.getStudentsFullNameOnCourseWithMapping(students);
        System.out.println(listOfStudentsFullNameOnEachCourseWithMapping);

        Map<Integer, StudentFullNameAndAverageMarkDto> studentsFullNameWithAverageMarkOnCourses = StudentUtils.getStudentsFullNameWithAverageMarkOnCourse(students);
        System.out.println(studentsFullNameWithAverageMarkOnCourses);

    }
}