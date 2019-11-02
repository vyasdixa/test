package com.busyqa.test.service;


import com.busyqa.test.domain.Event;
import com.busyqa.test.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event findById(int id){
        return eventRepository.findById(id).orElse(null);
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void delete(int id) {
        eventRepository.deleteById(id);
    }

}
