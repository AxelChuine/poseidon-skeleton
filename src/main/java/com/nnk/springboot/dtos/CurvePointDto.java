package com.nnk.springboot.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurvePointDto {
    private Integer id;
    private Integer curveId;
    private LocalDateTime asOfDate;
    private Double term;
    private Double value;
    private LocalDateTime creationDate;
}
