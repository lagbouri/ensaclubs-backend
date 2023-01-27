package me.oussa.ensaclubs.controller;

import jakarta.validation.Valid;
import me.oussa.ensaclubs.dto.StudentDto;
import me.oussa.ensaclubs.exceptions.StudentAlreadyExistsException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Integer studentId) throws StudentNotFoundException {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody StudentDto studentDto) throws StudentAlreadyExistsException {
        studentService.addStudent(studentDto);
    }

    // update student
    @PutMapping
    public void updateStudent(@Valid @RequestBody StudentDto studentDto) throws StudentNotFoundException {
        studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/{apogee}")
    public void deleteStudent(@PathVariable Integer apogee) throws StudentNotFoundException {
        studentService.deleteStudent(apogee);
    }

}
