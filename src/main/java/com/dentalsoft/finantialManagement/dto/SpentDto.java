package com.dentalsoft.finantialManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SpentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -1755629097157518L;

    private Long spentId;

    private LocalDate spentDate;
    @NotNull
    private BigDecimal spentAmount;

    private String spentDescription;

    private SpentTypeDto spentType;
    private SpentCategoryDto spentCategory;
}
