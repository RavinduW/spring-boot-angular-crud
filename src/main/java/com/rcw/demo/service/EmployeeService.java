package com.rcw.demo.service;

import com.rcw.demo.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO createEmployee(EmployeeDTO dto);

    EmployeeDTO getEmployeeData(String id);

    EmployeeDTO updateEmployee(String id,EmployeeDTO dto);

    Map<String,Boolean> deleteEmployee(String id);
}
