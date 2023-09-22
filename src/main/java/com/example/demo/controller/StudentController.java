package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/student/save")
    public String studentSave(@ModelAttribute StudentDTO studentDTO) {
        studentService.save(studentDTO);
        return "index";
    }

    @GetMapping("/students")
    public String students (Model model){
        List<StudentDTO> studentDTOList = studentService.findAll();
        model.addAttribute("studentList",studentDTOList);
        return "list";
    }

    @GetMapping("/student/{id}")
    public String student (@PathVariable("id") Long id, Model model) {
        try {
            StudentDTO studentDTO = studentService.findById(id);
            model.addAttribute("student", studentDTO);
            return "detail";
        } catch (NoSuchElementException e) {
            return "NotFound";
        }
    }
    @GetMapping("/student/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        try {
            StudentDTO studentDTO = studentService.findById(id);
            model.addAttribute("student", studentDTO);
            return "update";
        } catch (NoSuchElementException e) {
            return "NotFound";
        }
    }
    @PostMapping("/student/update")
    public String update(@ModelAttribute StudentDTO studentDTO) {
        studentService.update(studentDTO);
        return "redirect:/students";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
