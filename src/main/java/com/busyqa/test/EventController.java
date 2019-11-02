package com.busyqa.test;


import com.busyqa.test.domain.Event;
import com.busyqa.test.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Event findEvent(@PathVariable int id){
        return eventService.findById(id);
    }

    @PostMapping
    public void createPerson(@RequestBody Event event) {
        eventService.save(event);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        if (id == null) {
            throw new RuntimeException("ID must be provided to update an Event");
        }
        eventService.delete(id);
    }

}
