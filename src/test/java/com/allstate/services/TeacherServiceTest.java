package com.allstate.services;

import com.allstate.entities.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

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

        Teacher teach = new Teacher("Andreas",32,"Male");
        Teacher teacher = this.service.create(teach);

        assertEquals("Andreas",teacher.getName());
    }

    @Test
    public void shouldFindById() throws Exception{

        Teacher teach = new Teacher("Priya",32,"Female");
        this.service.create(teach);
        //Teacher teacher = this.service.findById(5);

        this.service.findById(1);
        assertEquals(1,teach.getId());
    }



}