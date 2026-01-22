package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.management.entity.Student;
import com.student.management.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1️⃣ Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 2️⃣ Show add student form
    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // 3️⃣ Save student
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // 4️⃣ View all students
    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> list = studentService.getAllStudents();
        model.addAttribute("students", list);
        return "view-students";
    }

    // 5️⃣ Delete student
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    
    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/searchStudent")
    public String searchStudentPage() {
        return "search-student";
    }

    @GetMapping("/searchResult")
    public String searchResult(@RequestParam(required = false) Integer id, Model model) {

        if (id == null) {
            model.addAttribute("student", null);
            return "search-result";
        }

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "search-result";
    }

    
}
