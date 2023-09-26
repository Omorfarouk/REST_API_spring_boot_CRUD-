package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Build crate employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
         return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //Build get all employee REST API
    @GetMapping
     public List<Employee>getAllEmployee(){
        return  employeeService.getAllEmployee();
     }

     //Build get employee by REST API
    @GetMapping("{id}")
    public  ResponseEntity<Employee>getEmployeeById(@PathVariable("id")  long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    //Build update employee REST API
    @PutMapping("{id}")
    public  ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id,  @RequestBody Employee employee){
      return  new ResponseEntity<Employee>(employeeService.upateEmployee(employee,id), HttpStatus.OK);
    }

    //Build delete employee REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully! ", HttpStatus.OK);
    }
}
