package com.nnk.springboot.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Integer id;

    @NotNull
    private String moodysRating;

    @NotNull
    private String sandPRating;

    @NotNull
    private String fitchRating;

    @NotNull
    private Integer orderNumber;
}
