package com.java.SpringBoot.controller;

import com.java.SpringBoot.entity.Departement;
import com.java.SpringBoot.service.DepartementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartementController.class)
class DepartementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartementService departementService;

    private Departement departement;

    @BeforeEach
    void setUp() {
        departement = Departement.builder()
                .departementAddress("Ahmedabad")
                .departementCode("IT-06")
                .departementName("IT")
                .departementId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Departement inputDepartment = Departement.builder()
                .departementAddress("Ahmedabad")
                .departementCode("IT-06")
                .departementName("IT")
                .build();

        Mockito.when(departementService.saveDepartement(inputDepartment))
                .thenReturn(departement);

        mockMvc.perform(post("/departements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"departmentName\":\"IT\",\n" +
                                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                                "\t\"departmentCode\":\"IT-06\"\n" +
                                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departementService.fetchDepartementById(1L))
                .thenReturn(departement);

        mockMvc.perform(get("/departements/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departementName").
                        value(departement.getDepartementName()));
    }
}