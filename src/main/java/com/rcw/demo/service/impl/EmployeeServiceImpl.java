package com.rcw.demo.service.impl;

import com.rcw.demo.dto.EmployeeDTO;
import com.rcw.demo.entity.Employee;
import com.rcw.demo.repository.EmployeeRepository;
import com.rcw.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
}
