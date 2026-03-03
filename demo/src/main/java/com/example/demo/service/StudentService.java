package com.example.demo.service;

import com.example.demo.Student;
import org.springframework.stereotype.Component;


@Component
public class StudentService implements IStudentService{
    @Override
    public Student save(Student student){
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return student;
    }

}
