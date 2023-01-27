package me.oussa.ensaclubs.mapper;

import me.oussa.ensaclubs.dto.StudentDto;
import me.oussa.ensaclubs.model.Club;
import me.oussa.ensaclubs.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static StudentDto mapToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setApogee(student.getApogee());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPhone(student.getPhone());
        studentDto.setEmail(student.getEmail());
        studentDto.setFiliere(student.getFiliere());
        studentDto.setImage(student.getImage());
        studentDto.setClubs(student.getClubs());
        studentDto.setCreatedAt(student.getCreatedAt());
        studentDto.setUpdatedAt(student.getUpdatedAt());
        return studentDto;
    }

    public static Student mapToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setApogee(studentDto.getApogee());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhone(studentDto.getPhone());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setFiliere(studentDto.getFiliere());
        student.setImage(studentDto.getImage());
        student.setCreatedAt(studentDto.getCreatedAt());
        student.setUpdatedAt(studentDto.getUpdatedAt());
        return student;
    }

    public static List<StudentDto> mapAllToDto(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(mapToDto(student));
        }
        return studentDtos;
    }

}
