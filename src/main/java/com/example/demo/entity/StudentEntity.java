package com.example.demo.entity;

import javax.persistence.*;

@Entity
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

}
