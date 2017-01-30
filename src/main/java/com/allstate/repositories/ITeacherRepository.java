package com.allstate.repositories;

import com.allstate.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {
}
