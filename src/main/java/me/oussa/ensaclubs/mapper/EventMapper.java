package me.oussa.ensaclubs.mapper;

import me.oussa.ensaclubs.dto.EventDto;
import me.oussa.ensaclubs.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static EventDto mapToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setDetails(event.getDetails());
        eventDto.setImage(event.getImage());
        eventDto.setClubId(event.getClub().getId());
        eventDto.setDate(event.getDate());
        return eventDto;
    }

    public static Event mapToEntity(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDetails(eventDto.getDetails());
        event.setImage(eventDto.getImage());
        event.setDate(eventDto.getDate());
        return event;
    }

    public static List<EventDto> mapAllToDto(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event : events) {
            eventDtos.add(mapToDto(event));
        }
        return eventDtos;
    }

}
