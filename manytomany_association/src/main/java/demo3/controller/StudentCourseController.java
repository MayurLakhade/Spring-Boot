package demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo3.entity.Student;
import demo3.repository.Course_Repo;
import demo3.repository.Student_Repo;

@RestController
//@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    private Student_Repo student_Repo;
    @Autowired
    private Course_Repo course_Repo;


    /*
     * {
"name":"padmaja",
"age":30,
"dept":"Dev",
"course":[
    {
       "courseName":"MachineLearning",
       "fees":50000
    },
    {
       "courseName":"spring boot",
       "fees":15000
    },
    {
        "courseName":"java",
       "fees":60000
    }
]
}
     */

    // post:- http://localhost:8080/student/course
    @PostMapping("/save")
    public Student saveStudentWithCourse(@RequestBody Student student)
    {
        return student_Repo.save(student);
    }

    //Get:- http://localhost:8080/student/course
    @GetMapping
    public List<Student> findAllStudents()
    {
        return student_Repo.findAll();
    }

    //Get:- http://localhost:8080/student/course/1
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable int id)
    {
        return student_Repo.findById(id).orElse(null);
    }

    //get:-http://localhost:8080/student/course/1
    @GetMapping("/{name}")
    public List<Student> findByStudentName(@PathVariable String name)
    {
        return student_Repo.findByName(name);
    }
    
}
