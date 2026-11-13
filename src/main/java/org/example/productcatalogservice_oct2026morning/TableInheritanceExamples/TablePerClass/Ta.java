package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="ta_tpc")
public class Ta extends User {
    private Double numOfHours;
}
