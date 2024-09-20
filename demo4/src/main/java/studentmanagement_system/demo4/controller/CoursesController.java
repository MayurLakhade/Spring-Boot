package studentmanagement_system.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import studentmanagement_system.demo4.entity.Courses;
import studentmanagement_system.demo4.service.CoursesService;

@RestController
public class CoursesController {
    @Autowired
	CoursesService cs;
	
	@GetMapping("/Courses/getcourses")
	public List<Courses> getCourses(){
		return cs.getAllCourses();
	}
	
	@GetMapping("/Courses/getcourses/{cid}")
	public ResponseEntity<Courses> getCourses(@PathVariable("cid") int cid){
		return new ResponseEntity<Courses>(cs.getCourseDetail(cid),HttpStatus.OK);
	}
    
}
