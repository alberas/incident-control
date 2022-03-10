package com.alberi.incidentcontrol.controller;

import java.util.List;
import java.util.Optional;

import com.alberi.incidentcontrol.model.Incident;
import com.alberi.incidentcontrol.repository.IncidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    private IncidentRepository ir;

    @GetMapping
    @CrossOrigin
    public List<Incident> findAll() {
        return ir.findAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Incident create(@RequestBody Incident incident) {
        return ir.save(incident);
    }

    @PutMapping(value = "/close", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Incident close(@RequestBody Integer id) {
        Optional<Incident> incident = ir.findById(id);
        if (!incident.isPresent()) {
            throw new RuntimeException("INCIDENT DOES NOT EXISTS!");
        }
        if (incident.get().getClosedAt() != null) {
            throw new RuntimeException("INCIDENT IS ALREADY CLOSED!");
        }
        Incident objIncident = incident.get();
        objIncident.setClosedAt(System.currentTimeMillis());
        return ir.save(objIncident);
    }

    @DeleteMapping(value = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public void remove(@RequestBody Integer id) {
        Optional<Incident> incident = ir.findById(id);
        if (!incident.isPresent()) {
            throw new RuntimeException("INCIDENT DOES NOT EXISTS!");
        }
        if (incident.get().getClosedAt() != null) {
            throw new RuntimeException("INCIDENT IS ALREADY CLOSED!");
        }
        Incident objIncident = incident.get();

        ir.delete(objIncident);
    }

}