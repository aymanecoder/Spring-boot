package com.java.SpringBoot.service;

import com.java.SpringBoot.entity.Departement;
import com.java.SpringBoot.error.DepartementNotFoundException;

import java.util.List;

public interface DepartementService{
     Departement saveDepartement(Departement departement);

     List<Departement> fetchDepartementList();

     Departement fetchDepartementById(Long departementId) throws DepartementNotFoundException;

     void deleteDepartementById(Long departementId);

     Departement updateDepartement(Long departementId, Departement departement);

     Departement fetchDepartementByName(String departementName);
     
     
}
