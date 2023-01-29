package com.java.SpringBoot.service;

import com.java.SpringBoot.entity.Departement;
import com.java.SpringBoot.repository.DepartementRepository;
import org.apache.catalina.filters.ExpiresFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartementServiceTest {
    @Autowired
    private DepartementService departementService;
    @MockBean
    private DepartementRepository departementRepository;

    @BeforeEach
    void setUp() {
        Departement departement = Departement.builder()
                .departementName("IT")
                .departementAddress("Ahmedabad")
                .departementCode("CE-07")
                .departementId(1L)
                .build();


        Mockito.when(departementRepository.findByDepartementNameIgnoreCase("IT"))
                .thenReturn(departement);

    }
    @Test
    @DisplayName("Get data based on departement name")
    public void whenValidDepartmentName_thenDepatementShouldFound(){
        String departmentName = "IT";
        Departement found = departementService.fetchDepartementByName(departmentName);
        assertEquals(departmentName, found.getDepartementName());

    }

}