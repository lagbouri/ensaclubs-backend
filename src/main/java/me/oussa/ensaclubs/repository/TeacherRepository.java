package me.oussa.ensaclubs.repository;

import me.oussa.ensaclubs.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findTeacherByCin(String cin);

}
