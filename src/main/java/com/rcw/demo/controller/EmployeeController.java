package com.rcw.demo.controller;

import com.rcw.demo.dto.EmployeeDTO;
import com.rcw.demo.entity.Employee;
import com.rcw.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeData(@PathVariable String id){
        EmployeeDTO dto = employeeService.getEmployeeData(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String id,@RequestBody EmployeeDTO dto){
        EmployeeDTO employee = employeeService.updateEmployee(id,dto);
        return ResponseEntity.ok(employee);
    }



}
