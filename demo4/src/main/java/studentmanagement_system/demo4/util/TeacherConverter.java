package studentmanagement_system.demo4.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import studentmanagement_system.demo4.entity.Teacher;
import studentmanagement_system.demo4.model.TeacherDTO;

@Component
public class TeacherConverter {
    //Converting teacher entity to teacher DTO

    public TeacherDTO convertTOTeacherDTO(Teacher teacher)
    {
        TeacherDTO tDto = new TeacherDTO();
        if(teacher != null)
        {
            // copy data from teacher to teacherDTO
            BeanUtils.copyProperties(teacher, tDto);
        }
        return tDto;
    }
    
    //Converting teacher DTO to teacher entity

    public Teacher convertTOEntity(TeacherDTO tDto)
    {
        Teacher teacher = new Teacher();
        if(tDto != null)
        {
            // copy data from teacherDTO to teacher
            BeanUtils.copyProperties(tDto, teacher);
        }
        return teacher;
    }
}
