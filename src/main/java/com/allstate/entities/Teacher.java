package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private Date created;
    private Date modified;
    private List<Klass> klasses;

    public Teacher() {}

    public Teacher(String name, int age, Gender gender) {
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

    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    @CreationTimestamp
    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }

    @UpdateTimestamp
    public Date getModified() { return modified; }
    public void setModified(Date modified) { this.modified = modified; }

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    public List<Klass> getKlasses() { return klasses; }
    public void setKlasses(List<Klass> klasses) { this.klasses = klasses;}
}
