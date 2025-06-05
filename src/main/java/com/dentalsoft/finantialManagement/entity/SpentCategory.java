package com.dentalsoft.finantialManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table
public class SpentCategory {
    @Id
    private Long id;
    private String name;
    private String description;

}
