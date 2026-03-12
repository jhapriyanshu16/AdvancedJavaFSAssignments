package com.lpu.LearnSpring.Service;

import com.lpu.LearnSpring.DTO.RequestDTO;
import com.lpu.LearnSpring.DTO.ResponseDTO;
import com.lpu.LearnSpring.Entity.Student;
import com.lpu.LearnSpring.repository.IStudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    private IStudentRepo iStudentRepo;

    public StudentService(IStudentRepo iStudentRepo) {
        this.iStudentRepo = iStudentRepo;
    }


    @Override
    public ResponseDTO saveStudent(RequestDTO student) {
        Student student1= Student.builder().email(student.getEmail())
                .name(student.getName())
                .build();

        Student savedStudent= iStudentRepo.save(student1);

        ResponseDTO studentResponseDTO= ResponseDTO.builder().id(savedStudent.getId()).name(savedStudent.getName()).email(savedStudent.getEmail()).build();
        return  studentResponseDTO;
    }
}
