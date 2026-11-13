package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="instructor_st")
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    private String company;
}
