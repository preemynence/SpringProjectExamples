package springStarterProject.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springStarterProject.dao.StudentDAO;
import springStarterProject.model.Student;
import springStarterProject.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public long createStudent(Student student) {
        return studentDAO.createStudent(student);
    }
    @Override
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
    @Override
    public void deleteStudent(long id) {
        studentDAO.deleteStudent(id);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
    @Override
    public Student getStudent(long id) {
        return studentDAO.getStudent(id);
    }
}
