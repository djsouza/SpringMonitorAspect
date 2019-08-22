package com.monitoringapp.web.employee;

import com.monitoringapp.business.EmployeeService;
import com.monitoringapp.web.employee.EmployeeRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestService.class)
public class EmployeeRestServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    public void listAll() throws Exception {

        mvc.perform(get("/employee/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
