package com.java.SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Departement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long departementId;
    @NotBlank(message = "Please Add DepartementName")
    private String departementName;
    private String departementAddress;
    private String departementCode;


}
