package me.oussa.ensaclubs.service;

import me.oussa.ensaclubs.dto.EventDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.mapper.EventMapper;
import me.oussa.ensaclubs.model.Club;
import me.oussa.ensaclubs.model.Event;
import me.oussa.ensaclubs.repository.ClubRepository;
import me.oussa.ensaclubs.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    public EventService(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    public void addEvent(EventDto eventDto) throws ClubNotFoundException {
        Club club = clubRepository.findById(eventDto.getClubId())
                .orElseThrow(() -> new ClubNotFoundException("Club with id " + eventDto.getClubId() + " not found"));
        Event event = EventMapper.mapToEntity(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByClub(Integer clubId) {
        return eventRepository.findEventsByClubId(clubId);
    }
}
