package trial.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trial.test.entity.Employee;

@Repository
public interface Employee_Repository extends JpaRepository<Employee, Integer>{

   public List<Employee> findByAddress(String ad); 

   public List<Employee> findBySalary(double sal);

    
}
