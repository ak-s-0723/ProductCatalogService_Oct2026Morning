package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="ta_st")
@DiscriminatorValue(value = "1")
public class Ta extends User {
    private Double numOfHours;
}
