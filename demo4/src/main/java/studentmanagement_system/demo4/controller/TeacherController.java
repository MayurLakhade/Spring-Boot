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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentmanagement_system.demo4.entity.Teacher;
import studentmanagement_system.demo4.model.TeacherDTO;
import studentmanagement_system.demo4.service.TeacherService;
import studentmanagement_system.demo4.util.TeacherConverter;

/*
 * postman - controller (DTO classes) - serviceImpl (DTO)(convertion of DTO classes into entity classes) 
 * 
 * database - entity - (convertion from entity classes to DTO class)
 */

@RestController
public class TeacherController {
    @Autowired
    TeacherService tService;

    @Autowired
    TeacherConverter tConverter;

    // @RequestMapping("/hello")
    // public String hello()
    // {
    //     return "Hello world";
    // }

    @PostMapping("/Teacher/addTeacher")
    public TeacherDTO saveTeacher(@RequestBody TeacherDTO tDto)
    {
        Teacher teacherl = tConverter.convertTOEntity(tDto);
        //return new ResponseEntity<Teacher>(tService.addTeacher(teacher), HttpStatus.CREATED);
        return tService.addTeacher(teacherl);
    }

    @GetMapping("/Teacher/getTeacher/{tid}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("tid") int tid)
    {
        return new ResponseEntity<Teacher>(tService.getTeacherDetails(tid),HttpStatus.OK);
    }

    @PutMapping("/Teacher/editTeacher/{tid}")
    public ResponseEntity<Teacher> editTeacher(@PathVariable("tid") int tid, @RequestBody Teacher teacher )
    {
        return new ResponseEntity<Teacher>(tService.updateTeacherDetails(teacher, tid), HttpStatus.OK);
    }

    @DeleteMapping("/Teacher/deleteTeacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("tid") int tid)
    {
        tService.deleteTeacherDetails(tid);
        return new ResponseEntity<String>("Deleted Successfully...", HttpStatus.OK);

    }

    
}

// @ControllerAdvice
// @Order(-1)
// class NoResourceFoundExceptionHandler {

//     @ExceptionHandler(NoResourceFoundException.class)
//     public final ResponseEntity<Object> handleResourceNotFound(Exception ex) throws Exception {
//         throw ex;
//     }

// }

/*
 * sid sfname slname slname semail seduc saddr
sphone
 */