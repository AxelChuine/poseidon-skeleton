package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RatingMapperTest {
    @InjectMocks
    private RatingMapper mapper;

    private final Integer id = 1;
    private final String moodysRating = "moodysRating";
    private final String sandPRating = "sandPRating";
    private final String fitchRating = "fitchRating";
    private final Integer orderNumber = 1;

    private Rating model;
    private RatingDto dto;
    private List<Rating> list = new ArrayList<>();
    private List<RatingDto> listDto = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.model = new Rating(
                this.id,
                this.moodysRating,
                this.sandPRating,
                this.fitchRating,
                this.orderNumber
        );
        this.dto = new RatingDto(
                this.id,
                this.moodysRating,
                this.sandPRating,
                this.fitchRating,
                this.orderNumber
        );
        this.list.add(this.model);
        this.listDto.add(this.dto);
    }

    @Test
    public void toDtoShouldReturnDto() {
        RatingDto toCompare = this.mapper.toDto(this.model);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void toModelShouldReturnModel() {
        Rating toCompare = this.mapper.toModel(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toDtoListShouldReturnADtoList() {
        List<RatingDto> toCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }

    @Test
    public void updateShouldReturnARatingModel() {
        // TODO: faire le test sur la méthode update
    }
}
