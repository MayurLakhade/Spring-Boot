package studentmanagement_system.demo4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import studentmanagement_system.demo4.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

    //jpql
	//Select * from Teacher where tname=?
	
	@Query("Select t from Teacher t where t.tphone=?1")
	Teacher findTeacherByPhone(long tphone);
	
	@Query("Select t from Teacher t where t.tname=?1")
	List<Teacher> findTeacherByName(String tname);
	
	@Query("Select t from Teacher t where t.designation like ?1% order by tname")
	List<Teacher> findTeacherDesignation(String designation);
    
}
