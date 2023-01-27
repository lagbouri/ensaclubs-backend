package me.oussa.ensaclubs.mapper;

import me.oussa.ensaclubs.dto.TeacherDto;
import me.oussa.ensaclubs.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapper {

    public static TeacherDto mapToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setCin(teacher.getCin());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setPhone(teacher.getPhone());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setDepartment(teacher.getDepartment());
        return teacherDto;
    }

    public static Teacher mapToEntity(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setCin(teacherDto.getCin());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhone(teacherDto.getPhone());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setDepartment(teacherDto.getDepartment());
        return teacher;
    }

    public static List<TeacherDto> mapAllToDto(List<Teacher> teachers) {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDtos.add(mapToDto(teacher));
        }
        return teacherDtos;
    }

}
