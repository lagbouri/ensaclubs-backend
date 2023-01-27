package me.oussa.ensaclubs.service;

import me.oussa.ensaclubs.dto.StudentDto;
import me.oussa.ensaclubs.exceptions.StudentAlreadyExistsException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.mapper.StudentMapper;
import me.oussa.ensaclubs.model.Student;
import me.oussa.ensaclubs.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return StudentMapper.mapAllToDto(studentRepository.findAll());
    }

    public StudentDto getStudent(Integer studentId) throws StudentNotFoundException {
        return StudentMapper.mapToDto(studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + studentId + " not found")));
    }

    public void addStudent(StudentDto studentDto) throws StudentAlreadyExistsException {

        if (studentRepository.findStudentByApogee(studentDto.getApogee()).isPresent()) {
            throw new StudentAlreadyExistsException("Student with apogee " + studentDto.getApogee() + " already exists");
        }

        Student student = StudentMapper.mapToEntity(studentDto);
        studentRepository.save(student);
    }

    public void deleteStudent(Integer apogee) throws StudentNotFoundException {
        if (studentRepository.findStudentByApogee(apogee).isEmpty()) {
            throw new StudentNotFoundException("Student with apogee " + apogee + " does not exists");
        }
        studentRepository.deleteStudentByApogee(apogee);
    }

    public void updateStudent(StudentDto studentDto) throws StudentNotFoundException {
        Student studentToUpdate = studentRepository.findStudentByApogee(studentDto.getApogee())
                .orElseThrow(() -> new StudentNotFoundException("Student with apogee " + studentDto.getApogee() + " does not exists"));

        BeanUtils.copyProperties(studentDto, studentToUpdate);

        studentRepository.save(studentToUpdate);
    }
}
