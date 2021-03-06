package springStarterProject.service;

import java.util.List;

import springStarterProject.model.Student;

public interface StudentService {
    public long createStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(long id);
    public List<Student> getAllStudents();
    public Student getStudent(long id);
}