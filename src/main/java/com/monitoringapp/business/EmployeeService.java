package com.monitoringapp.business;

import com.monitoringapp.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitoringapp.persistence.dao.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> listAll() {
        return employeeDAO.listAll();
    }

}
