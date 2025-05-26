package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.RatingListNullPointerException;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.mapper.impl.RatingMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {
    @InjectMocks
    private RatingService service;

    @Mock
    private RatingMapper mapper;

    @Mock
    private RatingRepository repository;

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
    public void findAllShouldReturnRatingDtoList() {
        Mockito.when(this.repository.findAll()).thenReturn(this.list);
        Mockito.when(this.mapper.toDtoList(this.list)).thenReturn(this.listDto);
        List<RatingDto> toCompare = this.service.findAll();

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }

    @Test
    public void findAllShouldThrowRatingListNullPointerException() {
        String message = "Rating list is null";

        RatingListNullPointerException exception = org.junit.jupiter.api.Assertions.assertThrows(RatingListNullPointerException.class, () -> this.service.findAll(), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void findByIdShouldReturnARatingDto() throws ParameterNotProvidedException {
        Mockito.when(this.repository.findById(this.id)).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        RatingDto toCompare = this.service.findById(this.id);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void updateShouldReturnARatingDto() throws ParameterNotProvidedException {
        Integer orderNumber = 2;
        Rating toUpdate = new Rating(
                this.id,
                this.moodysRating,
                this.sandPRating,
                this.fitchRating,
                orderNumber
        );
        RatingDto toUpdateDto = new RatingDto(
                this.id,
                this.moodysRating,
                this.sandPRating,
                this.fitchRating,
                orderNumber
        );
        Mockito.when(this.repository.findById(this.id)).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        Mockito.when(this.mapper.update(this.dto, toUpdateDto)).thenReturn(toUpdate);
        Mockito.when(this.repository.save(toUpdate)).thenReturn(toUpdate);
        Mockito.when(this.mapper.toDto(toUpdate)).thenReturn(toUpdateDto);
        RatingDto toCompare = this.service.update(this.id, toUpdateDto);

        Assertions.assertThat(toCompare).isEqualTo(toUpdateDto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(toUpdateDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(toUpdateDto.hashCode());
    }

    @Test
    public void findAllShouldThrowRatingNullPointerException() {
        String message = "The identifier was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.findById(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    public void deleteByIdShouldCallTheRepository() throws ParameterNotProvidedException {
        this.service.deleteById(this.id);
        Mockito.verify(this.repository, Mockito.times(1)).deleteById(this.id);
    }

    @Test
    public void deleteByIdShouldThrowParameterNotProvidedException() {
        String message = "The identifier was not provided, please try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.deleteById(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }
}
