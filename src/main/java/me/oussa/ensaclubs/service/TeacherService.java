package me.oussa.ensaclubs.service;

import me.oussa.ensaclubs.dto.TeacherDto;
import me.oussa.ensaclubs.exceptions.TeacherAlreadyExistsException;
import me.oussa.ensaclubs.exceptions.TeacherNotFoundException;
import me.oussa.ensaclubs.mapper.TeacherMapper;
import me.oussa.ensaclubs.model.Teacher;
import me.oussa.ensaclubs.repository.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDto> getAllTeachers() {
        return TeacherMapper.mapAllToDto(teacherRepository.findAll());
    }

    public void addTeacher(TeacherDto teacherDto) throws TeacherAlreadyExistsException {

        if (teacherRepository.findTeacherByCin(teacherDto.getCin()).isPresent()) {
            throw new TeacherAlreadyExistsException("Teacher with cin " + teacherDto.getCin() + " already exists");
        }

        Teacher teacher = TeacherMapper.mapToEntity(teacherDto);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer teacherId) throws TeacherNotFoundException {
        if (teacherRepository.findById(teacherId).isEmpty()) {
            throw new TeacherNotFoundException("Teacher with cin " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }

    public void updateTeacher(TeacherDto teacherDto) throws TeacherNotFoundException {
        Teacher teacherToUpdate = teacherRepository.findById(teacherDto.getId())
                .orElseThrow(() -> new TeacherNotFoundException("Teacher with id " + teacherDto.getId() + " does not exists"));

        BeanUtils.copyProperties(teacherDto, teacherToUpdate);

        teacherRepository.save(teacherToUpdate);
    }
}
