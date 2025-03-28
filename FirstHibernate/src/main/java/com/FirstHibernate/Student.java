//package com.FirstHibernate;
//
//
//@Entity
//@Table(name="student")
//public class Student {
//	
//	@Id
//int id;
//
//	@column
//String name;
//	@column
//String marks;
//	@column
//String email;
//
//public Student() {
//	
//}
//}



package com.FirstHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "marks")
    private String marks;

    @Column(name = "email")
    private String email;

    // Default constructor
    public Student() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


