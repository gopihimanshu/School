package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    StudentService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateNewStudent() throws Exception{
        Student st = new Student();
        st.setEmail("vsuz@allstate.com");

        Student student = this.service.create(st);
        assertEquals(2,student.getId());
        assertEquals("vsuz@allstate.com",student.getEmail());
    }

    @Test
    public void shouldFindById() throws Exception{
        Student st = this.service.findById(1);
        assertEquals("hkums@allstate.com",st.getEmail());

    }
    @Test
    public void shouldFindByEmail() throws Exception{
        Student st = this.service.findByEmail("hkums@allstate.com");
        assertEquals("hkums@allstate.com",st.getEmail());

    }

}