package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Long save(StudentDTO studentDTO) {
        //DTP -> Entity 변환을 위한 메서드 호출
        StudentEntity studentEntity = StudentEntity.toSaveEntity(studentDTO);
        Long saveId = studentRepository.save(studentEntity).getId();
        return saveId;
    }

    public List<StudentDTO> findAll() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            studentDTOList.add(StudentDTO.studentDTOList(studentEntity));
        }
        return studentDTOList;
    }

    public StudentDTO findById(Long id) {
        Optional<StudentEntity> studentRepositoryById = studentRepository.findById(id);
        if(studentRepositoryById.isPresent()) {
            // 있다
            StudentEntity studentEntity = studentRepositoryById.get();
            return StudentDTO.studentDTOList(studentEntity);
        }else {
            // 없다
            return null;
        }
    }
}
