package com.dentalsoft.finantialManagement.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class SpentTypeDto  implements Serializable {
    @Serial
    private static final long serialVersionUID = 150175562909715751L;
    private Long id;
    @Size(min = 1, max = 150 )
    @NotBlank
    private String name;

    private String description;

}
