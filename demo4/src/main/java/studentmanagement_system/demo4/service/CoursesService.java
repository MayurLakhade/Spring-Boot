package studentmanagement_system.demo4.service;

import java.util.List;

import studentmanagement_system.demo4.entity.Courses;

public interface CoursesService {
    Courses getCourseDetail(int cid);
	
	List<Courses> getAllCourses();
		
    
}
