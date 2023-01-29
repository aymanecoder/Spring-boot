package com.java.SpringBoot.repository;



import com.java.SpringBoot.entity.Departement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Departement department =
                Departement.builder()
                        .departementName("Mechanical Engineering")
                        .departementCode("ME - 011")
                        .departementAddress("Delhi")
                        .departementId(1L)
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Departement department = departementRepository.findById(1L).get();
        assertEquals(department.getDepartementName(), "Mechanical Engineering");
    }
}