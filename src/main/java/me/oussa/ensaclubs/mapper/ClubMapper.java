package me.oussa.ensaclubs.mapper;

import me.oussa.ensaclubs.dto.ClubDto;
import me.oussa.ensaclubs.model.Club;

import java.util.ArrayList;
import java.util.List;

public class ClubMapper {

    public static ClubDto mapToDto(Club club) {
        ClubDto clubDto = new ClubDto();
        clubDto.setId(club.getId());
        clubDto.setName(club.getName());
        clubDto.setDescription(club.getDescription());
        clubDto.setCategory(club.getCategory());
        clubDto.setImage(club.getImage());
        clubDto.setCreatorId(club.getCreator().getId());
        clubDto.setActivated(club.isActivated());
        clubDto.setUpdatedAt(club.getUpdatedAt());
        clubDto.setCreatedAt(club.getCreatedAt());
        clubDto.setStudents(club.getMembers());
        clubDto.setEvents(club.getEvents());
        return clubDto;
    }

    public static Club mapToEntity(ClubDto clubDto) {
        Club club = new Club();
        club.setName(clubDto.getName());
        club.setDescription(clubDto.getDescription());
        club.setCategory(clubDto.getCategory());
        club.setImage(clubDto.getImage());
        club.setActivated(clubDto.isActivated());
        return club;
    }

    public static List<ClubDto> mapAllToDto(List<Club> clubs) {
        List<ClubDto> clubDtos = new ArrayList<>();
        for (Club club : clubs) {
            clubDtos.add(mapToDto(club));
        }
        return clubDtos;
    }

}
