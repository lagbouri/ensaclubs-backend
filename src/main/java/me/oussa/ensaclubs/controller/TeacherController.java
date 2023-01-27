package me.oussa.ensaclubs.controller;

import jakarta.validation.Valid;
import me.oussa.ensaclubs.dto.TeacherDto;
import me.oussa.ensaclubs.exceptions.TeacherAlreadyExistsException;
import me.oussa.ensaclubs.exceptions.TeacherNotFoundException;
import me.oussa.ensaclubs.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public void addTeacher(@Valid @RequestBody TeacherDto teacherDto) throws TeacherAlreadyExistsException {
        teacherService.addTeacher(teacherDto);
    }

    // update student
    @PutMapping
    public void updateTeacher(@Valid @RequestBody TeacherDto teacherDto) throws TeacherNotFoundException {
        teacherService.updateTeacher(teacherDto);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Integer teacherId) throws TeacherNotFoundException {
        teacherService.deleteTeacher(teacherId);
    }

}
