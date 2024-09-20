package demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo3.entity.Course;

public interface Course_Repo extends JpaRepository<Course, Integer> {
    
}
