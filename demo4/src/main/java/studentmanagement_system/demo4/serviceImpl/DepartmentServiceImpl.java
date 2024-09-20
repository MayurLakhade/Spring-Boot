package studentmanagement_system.demo4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.DepartmentRepository;
import studentmanagement_system.demo4.entity.Department;
import studentmanagement_system.demo4.exception.DepartmentIdNotFoundException;
import studentmanagement_system.demo4.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
	DepartmentRepository drepo;

	@Override
	public Department getDeptDetail(int did) {
		return drepo.findById(did).orElseThrow(()-> new DepartmentIdNotFoundException("Incorrect Department id"));
	}

	@Override
	public Department updateDeptDetail(Department department, int did) {
		Department newDept = drepo.findById(did).orElseThrow(()-> new DepartmentIdNotFoundException("Incorrect Department id"));
		
		newDept.setOnOfEmpl(department.getOnOfEmpl());
		newDept.setDeptHOD(department.getDeptHOD());
		
		drepo.save(newDept);
		return newDept;
	}

	@Override
	public List<Department> getAllDept() {
	
		return drepo.findAll();
	}

    
    
}
