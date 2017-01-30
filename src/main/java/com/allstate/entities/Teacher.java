package com.allstate.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    private int id;
    private String name;
    private int age;
    private String gender;

    public Teacher() {}

    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NotNull
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

}
