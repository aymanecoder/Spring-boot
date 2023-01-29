package com.java.SpringBoot.repository;

import com.java.SpringBoot.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement findByDepartementName(String departementName);
    Departement findByDepartementNameIgnoreCase(String departementName);
}
