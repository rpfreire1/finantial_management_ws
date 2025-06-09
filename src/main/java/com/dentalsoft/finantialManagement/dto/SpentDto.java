package com.dentalsoft.finantialManagement.dto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.entity.SpentType;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class SpentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1501755629097157518L;
    private Long spentId;
    private LocalDate spentDate;
    private BigDecimal spentAmount;
    private String spentDescription;
    private SpentType spentType;
    private SpentCategory spentCategory;
}
