package springStarterProject.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springStarterProject.dao.StudentDAO;
import springStarterProject.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long createStudent(Student student) {
        Serializable id = sessionFactory.getCurrentSession().save(student);
        return (Long)id;
    }
    @Override
    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }
    @Override
    public void deleteStudent(long id) {
        Student student = new Student();
        student.setId(id);
        sessionFactory.getCurrentSession().delete(student);
    }
    @SuppressWarnings("unchecked")
	@Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Student e");
        return query.list();
    }
    @Override
    public Student getStudent(long id) {
        return (Student)sessionFactory.getCurrentSession().get(Student.class, id);
    }
}
