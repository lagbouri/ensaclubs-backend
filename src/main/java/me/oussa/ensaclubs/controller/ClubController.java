package me.oussa.ensaclubs.controller;

import jakarta.validation.Valid;
import me.oussa.ensaclubs.dto.ClubDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.model.Club;
import me.oussa.ensaclubs.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }


    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{clubId}")
    public Club getClub(@PathVariable Integer clubId) throws ClubNotFoundException {
        return clubService.getClub(clubId);
    }

    @PostMapping
    public void addClub(@Valid @RequestBody ClubDto clubDto) throws StudentNotFoundException {
        clubService.addClub(clubDto);
    }

    @DeleteMapping("/{clubId}")
    public void deleteClub(@PathVariable Integer clubId) throws ClubNotFoundException {
        clubService.deleteClub(clubId);
    }

    @PostMapping("/join/{clubId}/student/{studentId}")
    public void joinClub(@PathVariable Integer clubId, @PathVariable Integer studentId) throws ClubNotFoundException, StudentNotFoundException {
        clubService.joinClub(studentId, clubId);
    }
}
