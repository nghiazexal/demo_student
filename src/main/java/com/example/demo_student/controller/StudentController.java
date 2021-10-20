package com.example.demo_student.controller;

import com.example.demo_student.VO.ResponseTemplateVO;
import com.example.demo_student.entity.Student;
import com.example.demo_student.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithKhoa(@PathVariable("id") Long studentId) {
        return studentService.getStudentWithKhoa(studentId);
    }
    @GetMapping("/rate/{id}")
    public ResponseTemplateVO getStudentWithKhoa10(@PathVariable("id") Long studentId) {
        for (int i =0; i<10;i++){
            studentService.getStudentWithKhoa(studentId);
        }
        return studentService.getStudentWithKhoa(studentId);
    }
}
