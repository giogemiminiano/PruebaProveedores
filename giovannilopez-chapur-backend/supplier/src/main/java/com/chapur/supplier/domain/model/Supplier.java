package com.chapur.supplier.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Supplier {

    private UUID id;
    private String name;
    private String country;
    private Boolean active;
}
