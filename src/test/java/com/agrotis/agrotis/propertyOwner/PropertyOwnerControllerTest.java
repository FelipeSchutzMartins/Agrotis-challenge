package com.agrotis.agrotis.propertyOwner;

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
public class PropertyOwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPropertyOwner() throws Exception {
        mockMvc.perform(post("/laboratory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agro Skynet\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        mockMvc.perform(post("/property/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agrotis 1\", \"cnpj\": \"08562685000171\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(post("/propertyOwner/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Jon doe\", \"startDate\": \"2022-02-01\", \"endDate\": \"2022-02-02\", \"observations\": \"\", \"propertyId\": \"3\", \"laboratoryId\": \"2\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String id = jsonResponse.getString("id");
        String name = jsonResponse.getString("name");
        assertEquals(true, id != null);
        assertEquals(true, name.equals("Jon doe"));
    }

    @Test
    void updatePropertyOwner() throws Exception {
        mockMvc.perform(post("/laboratory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agro Skynet\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        mockMvc.perform(post("/property/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Agrotis 1\", \"cnpj\": \"08562685000171\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        mockMvc.perform(post("/propertyOwner/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Jon doe\", \"startDate\": \"2022-02-01\", \"endDate\": \"2022-02-02\", \"observations\": \"\", \"propertyId\": \"3\", \"laboratoryId\": \"2\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(put("/propertyOwner/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"name\": \"Jon\", \"startDate\": \"2022-02-01\", \"endDate\": \"2022-02-02\", \"observations\": \"\", \"propertyId\": \"3\", \"laboratoryId\": \"2\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String name = jsonResponse.getString("name");
        assertEquals(true, name.equals("Jon"));
    }

}
