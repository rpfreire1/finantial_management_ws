package com.dentalsoft.finantialManagement.entity;

import com.dentalsoft.finantialManagement.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table

public class Spent extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -631767203122514986L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long spentId;
    private LocalDate spentDate;
    private BigDecimal spentAmount;
    private String spentDescription;


    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "spent_category_id",referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private SpentCategory spentCategory;
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "spent_type_id",referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private SpentType spentType;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spent that = (Spent) o;
        return Objects.equals(spentId, that.spentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spentId);
    }
}
