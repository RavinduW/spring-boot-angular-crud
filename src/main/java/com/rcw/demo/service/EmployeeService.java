package com.rcw.demo.service;

import com.rcw.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO createEmployee(EmployeeDTO dto);

    EmployeeDTO getEmployeeData(String id);

    EmployeeDTO updateEmployee(String id,EmployeeDTO dto);
}
