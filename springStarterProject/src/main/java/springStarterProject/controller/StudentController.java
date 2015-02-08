package springStarterProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springStarterProject.model.Student;
import springStarterProject.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("createStudent")
    public ModelAndView createStudent(@ModelAttribute Student student) {
        return new ModelAndView("studentForm");
    }
    @RequestMapping("editStudent")
    public ModelAndView editStudent(@RequestParam long id, @ModelAttribute Student student) {
        student = studentService.getStudent(id);
        return new ModelAndView("studentForm", "studentObject", student);
    }
    @RequestMapping("saveStudent")
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        if(student.getId() == 0){ // if student id is 0 then creating the student other updating the student
            studentService.createStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return new ModelAndView("redirect:getAllStudents");
    }
    @RequestMapping("deleteStudent")
    public ModelAndView deleteStudent(@RequestParam long id) {
        studentService.deleteStudent(id);
        return new ModelAndView("redirect:getAllStudents");
    }
    @RequestMapping(value = {"getAllStudents", "/"})
    public ModelAndView getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        System.out.println(studentList.toString());
        return new ModelAndView("studentList", "studentList", studentList);
    }
}
