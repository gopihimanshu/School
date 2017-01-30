package com.allstate.entities;

import com.allstate.enums.Department;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "klasses")

public class Klass {
    private int id;
    private int version;
    private String name;
    private Date semester;
    private int credits;
    private Department department;
    private double fee;
    private Date created;
    private Date modified;
    private Teacher teacher;

    public Klass() {}

    public Klass(String name, Date semester, int credits, double fee, Department department) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.fee = fee;
        this.department = department;
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Version
    @Column(nullable = false)
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @Size(min = 1)
    @NotNull
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @NotNull
    public Date getSemester() { return semester; }
    public void setSemester(Date semester) { this.semester = semester; }

    @Min(value = 0)
    @NotNull
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    @Column(columnDefinition = "ENUM('SCIENCE', 'ENGINEERING','LITERATURE','PHILOSOPHY')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public com.allstate.enums.Department getDepartment() { return department; }
    public void setDepartment(com.allstate.enums.Department department) { this.department = department;}

    @DecimalMin(value = "0")
    @NotNull
    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    @CreationTimestamp
    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }

    @UpdateTimestamp
    public Date getModified() { return modified; }
    public void setModified(Date modified) {this.modified = modified; }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
}