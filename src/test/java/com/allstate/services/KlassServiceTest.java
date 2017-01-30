package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.enums.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    KlassService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateNewKlass() throws Exception {
        Klass klass = new Klass("Physics 101", Date.valueOf(LocalDate.now()), 4, 500, Department.SCIENCE);
        klass = this.service.create(klass);
        assertEquals(4, klass.getId());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassById() throws Exception {
        Klass klass = this.service.findById(1);
        assertEquals(1, klass.getId());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassByName() throws Exception {
        Klass klass = this.service.findByName("Physics 101");
        assertEquals(1, klass.getId());
    }


}