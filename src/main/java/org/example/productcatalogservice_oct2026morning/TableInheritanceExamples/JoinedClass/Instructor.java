package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="instructor_jc")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {
    private String company;
}
