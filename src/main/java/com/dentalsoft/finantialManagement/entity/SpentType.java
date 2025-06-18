package com.dentalsoft.finantialManagement.entity;

import com.dentalsoft.finantialManagement.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table

public class SpentType extends BaseEntity implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpentType that = (SpentType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
