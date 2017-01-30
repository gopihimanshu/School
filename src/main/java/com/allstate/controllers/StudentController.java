package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/student")

public class StudentController {
    private StudentService service;

    @Autowired
    public void setService(StudentService service){ this.service = service; }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        Student s = this.service.create(student);
        return s;
    }
}
