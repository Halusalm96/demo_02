package com.example.demo.entity;

import com.example.demo.dto.StudentDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter(AccessLevel.PACKAGE)
@Getter
@Table(name = "student_table")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String studentNumber;

    @Column(nullable = false, length = 20)
    private String studentName;

    @Column(nullable = false, length = 30)
    private String studentMobile;

    @Column(nullable = false, length = 50)
    private String studentMajor;

    // 기본생성자를 private으로
//    private StudentEntity () {
//
//    }

    // DTO -> Entity 변환 메서드
    public static StudentEntity toSaveEntity(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentNumber(studentDTO.getStudentNumber());
        studentEntity.setStudentName(studentDTO.getStudentName());
        studentEntity.setStudentMobile(studentDTO.getStudentMobile());
        studentEntity.setStudentMajor(studentDTO.getStudentMajor());
        return studentEntity;
    }
}
