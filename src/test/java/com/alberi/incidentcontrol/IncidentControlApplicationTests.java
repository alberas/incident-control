package com.alberi.incidentcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alberi.incidentcontrol.model.Incident;
import com.alberi.incidentcontrol.repository.IncidentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class IncidentControlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private IncidentRepository incidentRepo;
    @Autowired
    private MockMvc mvc;

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
        assertEquals(incidentRepo.findById(1).isPresent(), false);
    }

}
