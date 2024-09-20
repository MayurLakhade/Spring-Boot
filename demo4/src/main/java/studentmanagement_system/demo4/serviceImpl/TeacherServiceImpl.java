package studentmanagement_system.demo4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.TeacherRepository;
import studentmanagement_system.demo4.entity.Teacher;
import studentmanagement_system.demo4.exception.TeacherIdNotFoundException;
import studentmanagement_system.demo4.model.TeacherDTO;
import studentmanagement_system.demo4.service.TeacherService;
import studentmanagement_system.demo4.util.TeacherConverter;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository trepo;

    @Autowired
    TeacherConverter tConverter;

    @Override
    public TeacherDTO addTeacher(Teacher teacher) {
        trepo.save(teacher);
        return tConverter.convertTOTeacherDTO(teacher) ;

    }

    @Override
    public Teacher getTeacherDetails(int tid) {
        return trepo.findById(tid).orElseThrow(()-> new TeacherIdNotFoundException("teacher id is not found"));
    }

    @Override
    public Teacher updateTeacherDetails(Teacher teacher, int tid) {
        Teacher updateTeacher = trepo.findById(tid).orElseThrow(()-> new TeacherIdNotFoundException("teacher id is not found"));
        //set values;
        updateTeacher.setTphone(teacher.getTphone());
        updateTeacher.setDesignation(teacher.getDesignation());

        trepo.save(updateTeacher);
        return updateTeacher;
    }

    @Override
    public void deleteTeacherDetails(int tid) {
        trepo.findById(tid).orElseThrow(()-> new TeacherIdNotFoundException("Teacher id is not correct.."));
    }
    
}
