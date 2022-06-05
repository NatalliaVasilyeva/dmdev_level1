package org.dmdev.natalliavasilyeva.streams.dto;

import java.util.List;

public class StudentFullNameAndAverageMarkDto {

    private final List<StudentFullNameDto> studentFullNameDto;

    private final double averageMark;

    public StudentFullNameAndAverageMarkDto(List<StudentFullNameDto> studentFullNameDto, double averageMark) {
        this.studentFullNameDto = studentFullNameDto;
        this.averageMark = averageMark;
    }

    public List<StudentFullNameDto> getStudentFullNameDto() {
        return studentFullNameDto;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return "StudentFullNameAndAverageMarkDto{" +
                "studentFullNameDto=" + studentFullNameDto +
                ", averageMark=" + averageMark +
                '}';
    }
}