package studentmanagement_system.demo4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.CoursesRepository;
import studentmanagement_system.demo4.entity.Courses;
import studentmanagement_system.demo4.exception.CourseNotFoundException;
import studentmanagement_system.demo4.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService{

    
	@Autowired
	CoursesRepository crepo;

	@Override
	public Courses getCourseDetail(int cid) {
		// TODO Auto-generated method stub
		return crepo.findById(cid).orElseThrow(()-> new CourseNotFoundException("Incorrect Course Entered"));
	}

	@Override
	public List<Courses> getAllCourses() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}
    
}
