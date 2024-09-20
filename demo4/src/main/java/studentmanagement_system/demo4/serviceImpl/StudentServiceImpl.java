package studentmanagement_system.demo4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.StudentRepository;
import studentmanagement_system.demo4.entity.Students;
import studentmanagement_system.demo4.service.StudentsService;

@Service
public class StudentServiceImpl implements StudentsService{

    @Autowired
	StudentRepository srepo;

	@Override
	public Students addStudents(Students student) {
		return srepo.save(student);
	}

	@Override
	public Students getStudentsDetail(int sid) {	
		return srepo.findById(sid).orElse(null);//Throw(()-> new StudentIdNotException("Student id is incorrect"));
	}

	@Override
	public Students updateStudentsDetail(Students student, int sid) {
		Students updatedstudent = srepo.findById(sid).orElse(null); //Throw(()-> new StudentIdNotException("Student id is incorrect"));

		//set new values
		updatedstudent.setSeduc(student.getSeduc());
		srepo.save(updatedstudent);
		return updatedstudent;
	}

	@Override
	public void deleteStudentsDetail(int sid) {
		srepo.findById(sid).orElseThrow(null); //-> new StudentIdNotException("Student id is incorrect"));
		srepo.deleteById(sid);
		
	}
    
}
