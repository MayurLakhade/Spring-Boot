package trial.test.service;

import java.util.List;

import trial.test.entity.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee, int id);

    void deleteEmployee (int id);

    Employee getEmployee(int id);

    public List<Employee> getEmployeeBySalary(double sal);

    public List<Employee> getEmployeeByAddress(String ad);
}
