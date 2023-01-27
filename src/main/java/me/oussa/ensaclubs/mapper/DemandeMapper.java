package me.oussa.ensaclubs.mapper;

import me.oussa.ensaclubs.dto.DemandeDto;
import me.oussa.ensaclubs.model.Demande;

import java.util.ArrayList;
import java.util.List;

public class DemandeMapper {

    public static DemandeDto mapToDto(Demande demande) {
        DemandeDto demandeDto = new DemandeDto();
        demandeDto.setId(demande.getId());
        demandeDto.setObject(demande.getObject());
        demandeDto.setDetails(demande.getDetails());
        demandeDto.setImage(demande.getImage());
        demandeDto.setAccepted(demande.isAccepted());
        demandeDto.setCreatorId(demande.getCreator().getId());
        demandeDto.setClubId(demande.getClub().getId());
        demandeDto.setUpdatedAt(demande.getUpdatedAt());
        demandeDto.setCreatedAt(demande.getCreatedAt());
        return demandeDto;
    }

    public static Demande mapToEntity(DemandeDto demandeDto) {
        Demande demande = new Demande();
        demande.setObject(demandeDto.getObject());
        demande.setDetails(demandeDto.getDetails());
        demande.setImage(demandeDto.getImage());
        demande.setAccepted(demandeDto.isAccepted());
        return demande;
    }

    public static List<DemandeDto> mapAllToDto(List<Demande> demandes) {
        List<DemandeDto> demandeDtos = new ArrayList<>();
        for (Demande demande : demandes) {
            demandeDtos.add(mapToDto(demande));
        }
        return demandeDtos;
    }

}
