package com.dentalsoft.finantialManagement.dto;

import com.dentalsoft.finantialManagement.entity.SpentCategory;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class SpentCategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1501755629097157518L;
    private Long id;
    private String name;
    private String description;


}
