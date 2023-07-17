package com.agrotis.agrotis.laboratory;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
public class LaboratoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createLaboratory() throws Exception {
        MvcResult result = mockMvc.perform(post("/laboratory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Agro Skynet\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String id = jsonResponse.getString("id");
        String name = jsonResponse.getString("name");
        assertEquals(true, id != null);
        assertEquals(true, name.equals("Agro Skynet"));
    }

    @Test
    void updateLaboratory() throws Exception {
        mockMvc.perform(post("/laboratory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agro Skynet\"}"));

        MvcResult result = mockMvc.perform(put("/laboratory/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"name\": \"Agro\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String name = jsonResponse.getString("name");
        assertEquals(true, name.equals("Agro"));
    }

}
