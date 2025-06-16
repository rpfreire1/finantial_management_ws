package com.dentalsoft.finantialManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
@EqualsAndHashCode
public class SpentType implements Serializable {
    @Serial
    private static final long serialVersionUID = -631767203122514986L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false, name = "name", length = 100)
    private String name;
    @Column(nullable = false, name = "description", length = 255)
    private String description;
    @Version
    private Long version;

}
