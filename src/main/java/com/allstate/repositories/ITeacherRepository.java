package com.allstate.repositories;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {

    public Teacher findByName(String name);

    public List<Teacher> findByGender(Gender gender);

    public List<Teacher> findByAgeGreaterThan(int age);
}
