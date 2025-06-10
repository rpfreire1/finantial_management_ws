package com.dentalsoft.finantialManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spentId;
    private LocalDate spentDate;
    private BigDecimal spentAmount;
    private String spentDescription;
    @ManyToOne
    @JoinColumn(name = "spent_category_id",referencedColumnName = "id", nullable = true)
    private SpentCategory spentCategory;
    @ManyToOne
    @JoinColumn(name = "spent_type_id",referencedColumnName = "id", nullable = true)
    private SpentType spentType;
}
