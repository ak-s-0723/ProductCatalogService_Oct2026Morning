package org.example.productcatalogservice_oct2026morning.TableInheritanceExamples.SingleTable;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name="user_st")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {

    @Id
    private UUID id;
    private String name;
}
