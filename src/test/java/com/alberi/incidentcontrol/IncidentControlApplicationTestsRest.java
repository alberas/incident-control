package com.alberi.incidentcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alberi.incidentcontrol.controller.IncidentController;
import com.alberi.incidentcontrol.model.Incident;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IncidentController.class)
class IncidentControlApplicationTestsRest {

    @Autowired
    private MockMvc mvc;

    @Test
    void create() throws Exception {
        Incident incident = new Incident();
        incident.setId(1);
        incident.setName("Teste 001");
        incident.setDescription("description Teste 001");
        incident.setCreatedAt(System.currentTimeMillis());

        RequestBuilder request = MockMvcRequestBuilders.post("/create", incident.toString());
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(incident.toString(), result.getResponse().getContentAsString());
    }

}
