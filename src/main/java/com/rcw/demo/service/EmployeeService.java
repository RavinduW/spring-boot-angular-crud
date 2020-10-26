package com.rcw.demo.service;

import com.rcw.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO createEmployee(EmployeeDTO dto);

}
