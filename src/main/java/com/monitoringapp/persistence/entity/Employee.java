package com.monitoringapp.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "of")
public @Data class Employee {

    private Long id;

    private String firstName;

    private String lastName;

}
