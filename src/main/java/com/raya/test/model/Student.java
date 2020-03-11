package com.raya.test.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", unique = true)
    private Long idStudent;


    @NotNull
    @NotBlank
    @Column(name = "name")
    @NotEmpty(message = "name is required")
    private String name;


    @NotNull
    @Column(name = "age")
    private int age;



    @OneToMany(mappedBy = "student", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Lesson> lessons;


    @Column(name = "CREATED_AT",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATE_AT",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();

    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + idStudent +
                '}';
    }
}
