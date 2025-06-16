package com.dentalsoft.finantialManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
@EqualsAndHashCode
public class Spent implements Serializable {
    @Serial
    private static final long serialVersionUID = -631767203122514986L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long spentId;
    private LocalDate spentDate;
    private BigDecimal spentAmount;
    private String spentDescription;
    @Version
    private Long version;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "spent_category_id",referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private SpentCategory spentCategory;
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "spent_type_id",referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private SpentType spentType;
}
