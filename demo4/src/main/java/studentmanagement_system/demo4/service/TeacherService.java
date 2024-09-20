package studentmanagement_system.demo4.service;

import studentmanagement_system.demo4.entity.Teacher;
import studentmanagement_system.demo4.model.TeacherDTO;

public interface TeacherService {
    TeacherDTO addTeacher(Teacher teacher);

    Teacher getTeacherDetails(int tid);

    Teacher updateTeacherDetails(Teacher teacher, int tid);

    void deleteTeacherDetails(int tid);

   /*  getAllTeacher();

    getTeacherByPhone();

    getTeacherByName();

    getTeacherByDesignation();*/
    
}
