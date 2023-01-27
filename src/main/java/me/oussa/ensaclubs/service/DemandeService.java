package me.oussa.ensaclubs.service;

import me.oussa.ensaclubs.dto.DemandeDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.mapper.DemandeMapper;
import me.oussa.ensaclubs.model.Club;
import me.oussa.ensaclubs.model.Demande;
import me.oussa.ensaclubs.model.Student;
import me.oussa.ensaclubs.repository.ClubRepository;
import me.oussa.ensaclubs.repository.DemandeRepository;
import me.oussa.ensaclubs.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;
    private final StudentRepository studentRepository;
    private final ClubRepository clubRepository;

    public DemandeService(DemandeRepository demandeRepository, StudentRepository studentRepository, ClubRepository clubRepository) {
        this.demandeRepository = demandeRepository;
        this.studentRepository = studentRepository;
        this.clubRepository = clubRepository;
    }

    public void createDemande(DemandeDto demandeDto) throws StudentNotFoundException, ClubNotFoundException {
        Student student = studentRepository.findById(demandeDto.getCreatorId())
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + demandeDto.getCreatorId() + " not found"));

        Club club = clubRepository.findById(demandeDto.getClubId())
                .orElseThrow(() -> new ClubNotFoundException("Club with id " + demandeDto.getClubId() + " does not exists"));

        Demande demande = DemandeMapper.mapToEntity(demandeDto);
        demande.setCreator(student);
        demande.setClub(club);
        demandeRepository.save(demande);
    }

    public List<Demande> getDemandes() {
        return demandeRepository.findAll();
    }
}
