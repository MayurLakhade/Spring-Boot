package studentmanagement_system.demo4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentmanagement_system.demo4.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    
}
