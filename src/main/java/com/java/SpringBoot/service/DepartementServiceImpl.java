package com.java.SpringBoot.service;

import com.java.SpringBoot.entity.Departement;
import com.java.SpringBoot.error.DepartementNotFoundException;
import com.java.SpringBoot.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService{
    @Autowired
    private DepartementRepository departementRepository;
    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);

    }

    @Override
    public List<Departement> fetchDepartementList() {
        return departementRepository.findAll();
    }

    @Override
    public Departement fetchDepartementById(Long departementId) throws DepartementNotFoundException {
        Optional<Departement> departement = departementRepository.findById(departementId);
        if (!departement.isPresent()) {
            throw new DepartementNotFoundException("departement not available");

        }
        return departement.get();
    }

    @Override
    public void deleteDepartementById(Long departementId) {
         departementRepository.deleteById(departementId);
    }

    @Override
    public Departement updateDepartement(Long departementId, Departement departement) {
        Departement depDB = departementRepository.findById(departementId).get();
        if(Objects.nonNull(departement.getDepartementName()) && !"".equalsIgnoreCase(departement.getDepartementName())){
                depDB.setDepartementName(departement.getDepartementName());
        }
        if(Objects.nonNull(departement.getDepartementAddress()) && !"".equalsIgnoreCase(departement.getDepartementAddress())){
            depDB.setDepartementAddress(departement.getDepartementAddress());
        }
        if(Objects.nonNull(departement.getDepartementCode()) && !"".equalsIgnoreCase(departement.getDepartementCode())){
            depDB.setDepartementCode(departement.getDepartementCode());
        }
        return departementRepository.save(depDB);
    }

    @Override
    public Departement fetchDepartementByName(String departementName) {
        return departementRepository.findByDepartementNameIgnoreCase(departementName);
    }
}
