package com.java.SpringBoot.controller;

import com.java.SpringBoot.entity.Departement;
import com.java.SpringBoot.error.DepartementNotFoundException;
import com.java.SpringBoot.service.DepartementService;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController  {

    @Autowired
    private DepartementService departementService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartementController.class);


    @PostMapping("/departements")
    public Departement SaveDepartement(@Valid @RequestBody Departement departement) {
            LOGGER.info("inside SaveDepartement of DepartementController");
            return departementService.saveDepartement(departement);
    }
    @GetMapping("/departements")
    public List<Departement> fetchDepartementList(){
        LOGGER.info("inside fetchDepartementList of DepartementController");
        return departementService.fetchDepartementList();
    }
    @GetMapping("/departements/{id}")
    public Departement fetchDepartementById(@PathVariable("id") Long departementId) throws DepartementNotFoundException {
        return departementService.fetchDepartementById(departementId);
    }
    @DeleteMapping("/departements/{id}")
    public String deleteDepartementById(@PathVariable("id") Long departementId){
        departementService.deleteDepartementById(departementId);
        return "departement deleted successfully";
    }
    @PutMapping("/departements/{id}")
    public Departement updateDepartement(@PathVariable("id") Long departementId, @RequestBody Departement departement){
        return departementService.updateDepartement(departementId, departement);
    }

    @GetMapping("/departements/name/{name}")
    public Departement fetchDepartementByName(@PathVariable("name") String departementName){
        return departementService.fetchDepartementByName(departementName);
    }
}
