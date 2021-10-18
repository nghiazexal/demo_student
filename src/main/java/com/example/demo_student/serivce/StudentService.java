package com.example.demo_student.serivce;


import com.example.demo_student.VO.Khoa;
import com.example.demo_student.VO.ResponseTemplateVO;
import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Retry(name="basic")
    public ResponseTemplateVO getStudentWithKhoa(Long studentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findById(studentId).get();
        vo.setStudent(student);
        Khoa khoa =
                restTemplate.getForObject("http://localhost:9001/khoa/"
                                + student.getKhoaId(),
                        Khoa.class);
        log.info(khoa+"");
        vo.setKhoa(khoa);
        return vo;
    }

}
