package trial.test.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trial.test.entity.Employee;
import trial.test.exception.EmployeeNotFoundException;
import trial.test.repository.Employee_Repository;
import trial.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    Employee_Repository eRepository;

    @Override
    public Employee addEmployee(Employee employee) {
       return eRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee updatEmployee = eRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));

        updatEmployee.setName(employee.getName());
        updatEmployee.setAddress(employee.getAddress());
        updatEmployee.setSalary(employee.getSalary());

        return eRepository.save(updatEmployee);
        
        
    }

    @Override
    public void deleteEmployee(int id) {
        
        eRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));
        eRepository.deleteById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        
        return eRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Entered employee is absent"));
    }

    // public EmployeeServiceImpl(Employee_Repository eRepository)
    // {
    //     this.eRepository = eRepository;
    // }

    @Override
    public List<Employee> getEmployeeByAddress(String ad)
    {
        List<Employee> employees = eRepository.findByAddress(ad);
        if(employees.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee with given address is not found");
        }
        return employees;
        
    }

    @Override
    public List<Employee> getEmployeeBySalary(double sal) 
    {
        return eRepository.findBySalary(sal);
        
    }
    
}
