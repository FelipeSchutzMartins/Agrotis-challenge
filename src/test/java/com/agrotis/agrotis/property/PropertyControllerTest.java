package com.agrotis.agrotis.property;

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
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createProperty() throws Exception {
        MvcResult result = mockMvc.perform(post("/property/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Agrotis 1\", \"cnpj\": \"08562685000171\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String id = jsonResponse.getString("id");
        String cnpj = jsonResponse.getString("cnpj");
        String name = jsonResponse.getString("name");
        assertEquals(true, id != null);
        assertEquals(true, cnpj.equals("08562685000171"));
        assertEquals(true, name.equals("Agrotis 1"));
    }

    @Test
    void updateProperty() throws Exception {
        mockMvc.perform(post("/property/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agrotis 1\", \"cnpj\": \"08562685000171\"}"));

        MvcResult result = mockMvc.perform(put("/property/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"name\": \"Agrotis 2\", \"cnpj\": \"08562685000172\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String cnpj = jsonResponse.getString("cnpj");
        String name = jsonResponse.getString("name");
        assertEquals(true, cnpj.equals("08562685000172"));
        assertEquals(true, name.equals("Agrotis 2"));
    }

}
