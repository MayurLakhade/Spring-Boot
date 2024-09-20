package studentmanagement_system.demo4.service;

import java.util.List;

import studentmanagement_system.demo4.entity.Department;

public interface DepartmentService {
    Department getDeptDetail(int did);
	
	List<Department> getAllDept();
		
	Department updateDeptDetail(Department department, int did);
    
}
