package com.alberi.incidentcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alberi.incidentcontrol.controller.IncidentController;
import com.alberi.incidentcontrol.model.Incident;
import com.alberi.incidentcontrol.repository.IncidentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IncidentController.class)
public class IncidentTest {

    @Autowired
    private IncidentRepository incidentRepo;

    @Test
    void create() throws Exception {
        Incident incident = new Incident();
        incident.setId(1);
        incident.setName("Teste 001");
        incident.setDescription("description Teste 001");
        incident.setCreatedAt(System.currentTimeMillis());
        incidentRepo.save(incident);
        assertNotNull(incidentRepo.findById(1).get());
    }

    @Test
    void delete() throws Exception {
        Incident incident = new Incident();
        incident.setId(1);
        incident.setName("Teste 001");
        incident.setDescription("description Teste 001");
        incident.setCreatedAt(System.currentTimeMillis());
        incidentRepo.delete(incident);
        assertEquals(incidentRepo.findById(1).get(), null);
    }
}
