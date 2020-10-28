package com.rcw.demo.service.impl;

import com.rcw.demo.dto.EmployeeDTO;
import com.rcw.demo.entity.Employee;
import com.rcw.demo.exception.ResourceNotFoundException;
import com.rcw.demo.repository.EmployeeRepository;
import com.rcw.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();

        for(Employee e:employeeList){
            EmployeeDTO dto = new EmployeeDTO();

            if(e.getId() != null){
                dto.setId(e.getId().toString());
            }

            if(e.getFirstName() != null && !e.getFirstName().isEmpty()){
                dto.setFirstName(e.getFirstName());
            }else{
                dto.setFirstName("-");
            }

            if(e.getLastName() != null && !e.getLastName().isEmpty()){
                dto.setLastName(e.getLastName());
            }else{
                dto.setLastName("-");
            }

            if(e.getEmailId() != null && !e.getEmailId().isEmpty()){
                dto.setEmailId(e.getEmailId());
            }else{
                dto.setEmailId("-");
            }

            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmailId(dto.getEmailId());

        employeeRepository.save(employee);

        dto.setId(employee.getId().toString());

        return dto;
    }

    @Override
    public EmployeeDTO getEmployeeData(String id) {
        Employee employee = employeeRepository.findById(new Long(id)).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id "+id));

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId().toString());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmailId(employee.getEmailId());

        System.out.println("Test DTO Success");
        return dto;
    }

    @Override
    public EmployeeDTO updateEmployee(String id,EmployeeDTO dto) {

        Employee employee = employeeRepository.findById(new Long(id)).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id "+id));

        employee.setFirstName(dto.getFirstName().trim());
        employee.setLastName(dto.getLastName().trim());
        employee.setEmailId(dto.getEmailId().trim());

        employeeRepository.save(employee);

        dto.setId(employee.getId().toString());

        return dto;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(String id) {

        Employee employee = employeeRepository.findById(new Long(id)).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id "+id));

        employeeRepository.delete(employee);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);

        return response;
    }
}
