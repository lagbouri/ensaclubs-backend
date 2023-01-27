package me.oussa.ensaclubs.controller;

import jakarta.validation.Valid;
import me.oussa.ensaclubs.dto.EventDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.model.Event;
import me.oussa.ensaclubs.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void addEvent(@Valid @RequestBody EventDto eventDto) throws ClubNotFoundException {
        eventService.addEvent(eventDto);
    }

    @GetMapping("")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/club/{clubId}")
    public List<Event> getEventsByClub(@PathVariable Integer clubId) {
        return eventService.getEventsByClub(clubId);
    }
}
