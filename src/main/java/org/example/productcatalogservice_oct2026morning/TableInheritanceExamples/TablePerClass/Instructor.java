package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="instructor_tpc")
public class Instructor extends User {
    private String company;
}
