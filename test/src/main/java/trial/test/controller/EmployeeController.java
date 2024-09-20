package trial.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import trial.test.entity.Employee;
import trial.test.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class EmployeeController {

    @Autowired
    EmployeeService eService;


    @PostMapping("/Employee/addEmployees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(eService.addEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/Employee/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) 
    {

        return new ResponseEntity<Employee>(eService.getEmployee(id),HttpStatus.OK);
    }

    @DeleteMapping("/Employee/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
    {
        eService.deleteEmployee(id);
        return new ResponseEntity<String>("Deleted Successfully.",HttpStatus.OK);
    }

    @GetMapping("Employee/getEmployeeByAddress/by-add")
    public List<Employee> getEmployeeByAddress(@RequestParam("add") String add) 
    {
        return eService.getEmployeeByAddress(add);
    }

    @GetMapping("Employee/getEmployeeBySalary/by-sal")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam ("sal") double sal) {

        List<Employee> employees = eService.getEmployeeBySalary(sal);

        if(employees.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK); 
    }
    


    @PutMapping("/Employee/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable("id") int id, @RequestBody Employee employee) {
        
        return new ResponseEntity<Employee>(eService.updateEmployee(employee, id), HttpStatus.OK);
    }


    
    
       

    
}
