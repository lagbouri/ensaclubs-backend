package me.oussa.ensaclubs.service;

import me.oussa.ensaclubs.dto.ClubDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.mapper.ClubMapper;
import me.oussa.ensaclubs.model.Club;
import me.oussa.ensaclubs.model.Student;
import me.oussa.ensaclubs.repository.ClubRepository;
import me.oussa.ensaclubs.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final StudentRepository studentRepository;

    public ClubService(ClubRepository clubRepository, StudentRepository studentRepository) {
        this.clubRepository = clubRepository;
        this.studentRepository = studentRepository;
    }

    public void addClub(ClubDto clubDto) throws StudentNotFoundException {

        Club club = ClubMapper.mapToEntity(clubDto);

        if (clubDto.getCreatorId() != null) {
            Student student = studentRepository.findById(clubDto.getCreatorId())
                    .orElseThrow(() -> new StudentNotFoundException("Student with id " + clubDto.getCreatorId() + " does not exists"));
            club.setCreator(student);
        }

        clubRepository.save(club);
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public void deleteClub(Integer clubId) throws ClubNotFoundException {
        if (clubRepository.findById(clubId).isEmpty()) {
            throw new ClubNotFoundException("Club with id " + clubId + " does not exists");
        }
        clubRepository.deleteById(clubId);
    }

    public void joinClub(Integer studentId, Integer clubId) throws StudentNotFoundException, ClubNotFoundException {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student with id " + studentId + " does not exists"));
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException("Club with id " + clubId + " does not exists"));
        student.getClubs().add(club);
        // club.getStudents().add(student);
        studentRepository.save(student);
        // clubRepository.save(club);
    }

    public Club getClub(Integer clubId) throws ClubNotFoundException {
        return clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException("Club with id " + clubId + " does not exists"));
    }
}
