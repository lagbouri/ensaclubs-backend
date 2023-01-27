package me.oussa.ensaclubs.repository;

import me.oussa.ensaclubs.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findEventsByClubId(Integer clubId);
}