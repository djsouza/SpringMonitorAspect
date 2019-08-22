package com.monitoringapp.web.employee;

import com.monitoringapp.monitoring.annotation.Monitor;
import com.monitoringapp.business.EmployeeService;
import com.monitoringapp.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestService {

    @Autowired
    private EmployeeService employeeService;

    @Monitor(maxTime = 1000)
    @GetMapping("/employee/all")
    public List<Employee> listAll() {
        return employeeService.listAll();
    }

}
