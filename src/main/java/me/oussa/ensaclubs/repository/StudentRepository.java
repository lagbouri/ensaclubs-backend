package me.oussa.ensaclubs.repository;

import jakarta.transaction.Transactional;
import me.oussa.ensaclubs.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findStudentByApogee(Integer apogee);

    @Transactional
    void deleteStudentByApogee(Integer apogee);
}
