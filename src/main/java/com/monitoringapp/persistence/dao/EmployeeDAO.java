package com.monitoringapp.persistence.dao;

import com.monitoringapp.persistence.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmployeeDAO {

    public List<Employee> listAll() {
        return Stream.generate(() -> Employee.of(0L, "David", "Souza")).limit(100).collect(Collectors.toList());
    }

}
