package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Autowired
    TeacherService service;

    @Test
    public void shouldCreateNewTeacher() throws Exception{

        Teacher teach = new Teacher("Andreas",32,Gender.MALE);
        Teacher teacher = this.service.create(teach);

        assertEquals("Andreas",teacher.getName());
    }

    @Test
    public void shouldFindById() throws Exception{

        Teacher teach = new Teacher("Priya",32,Gender.FEMALE);
        teach = this.service.create(teach);
        this.service.findById(5);
        assertEquals(5,teach.getId());
    }

    @Test
    public void shouldFindByGender() throws Exception {

        List<Teacher> teacherList = this.service.findByGender(Gender.MALE);
        assertEquals(3,teacherList.size());
        assertEquals("Andreas", teacherList.get(0).getName());

    }

    @Test
    public void shouldFindAgeGreaterThan() throws Exception {
        List<Teacher> teacherList = this.service.findByAgeGreaterThan(20);
        assertEquals(4,teacherList.size());
    }
}