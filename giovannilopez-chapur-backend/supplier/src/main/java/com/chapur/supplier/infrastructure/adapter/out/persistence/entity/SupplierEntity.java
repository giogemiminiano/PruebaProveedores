package com.chapur.supplier.infrastructure.adapter.out.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Entity
@Table(name="Supplier")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "active=true")
public class SupplierEntity {

    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="active")
    private Boolean active;
}
