package demo3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo3.entity.Student;

public interface Student_Repo extends JpaRepository<Student, Integer>{

    List<Student> findByName(String name);
    
}
