package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private ITeacherRepository repository;

    @Autowired
    public void setRepository(ITeacherRepository repository){ this.repository = repository; }

    public Teacher create(Teacher teacher){ return this.repository.save(teacher); }

    public Teacher findById(int id){ return this.repository.findOne(id); }


}
