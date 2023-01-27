package me.oussa.ensaclubs.controller;

import jakarta.validation.Valid;
import me.oussa.ensaclubs.dto.DemandeDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.model.Demande;
import me.oussa.ensaclubs.service.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public void createDemande(@Valid @RequestBody DemandeDto demandDto) throws ClubNotFoundException, StudentNotFoundException {
        demandeService.createDemande(demandDto);
    }

    @GetMapping
    public List<Demande> getDemandes() {
        return demandeService.getDemandes();
    }

}
