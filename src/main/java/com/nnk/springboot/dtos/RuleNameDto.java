package com.nnk.springboot.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleNameDto {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String json;

    @NotNull
    private String template;

    @NotNull
    private String sqlStr;

    @NotNull
    private String sqlPart;
}
