package studentmanagement_system.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import studentmanagement_system.demo4.entity.Students;
import studentmanagement_system.demo4.service.StudentsService;

@RestController
public class StudentsController {

    	@Autowired
	StudentsService ss;
	
	@PostMapping("/Students/addStudents")
	public ResponseEntity<Students> saveStudenss(@Valid @RequestBody Students studenss){
		return new ResponseEntity<Students>(ss.addStudents(studenss),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/Students/gesstudents/{sid}")
	public ResponseEntity<Students> gesstudenss(@PathVariable("sid") int sid){
		return new ResponseEntity<Students>(ss.getStudentsDetail(sid),HttpStatus.OK);
	}
	
	@DeleteMapping("Students/removeStudents/{sid}")
	public ResponseEntity<String> deleteStudenss(@PathVariable("sid") int sid){
		ss.deleteStudentsDetail(sid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	
	@PutMapping("/Students/edisstudents/{sid}")
	public ResponseEntity<Students> edisstudenss(@Valid @PathVariable("sid") int sid, @RequestBody Students students){
		return new ResponseEntity<Students>(ss.updateStudentsDetail(students, sid), HttpStatus.OK);
	}
    
}
