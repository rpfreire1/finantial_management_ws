package com.dentalsoft.finantialManagement.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SpentTypeDto  implements Serializable {
    @Serial
    private static final long serialVersionUID = 150175562909715751L;
    private Long id;
    private String name;

    private String description;

}
