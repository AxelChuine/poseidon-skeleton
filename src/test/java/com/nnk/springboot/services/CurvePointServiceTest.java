package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import com.nnk.springboot.exceptions.CurvePointIsNullException;
import com.nnk.springboot.exceptions.CurvePointNotFoundException;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.mapper.impl.CurvePointMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {
    @InjectMocks
    private CurvePointService service;

    @Mock
    private CurvePointRepository repository;

    @Mock
    private CurvePointMapper mapper;

    private final Integer id = 1;
    private final Integer curveId = 1;
    private final Timestamp asOfDate = Timestamp.from(Instant.now());
    private final Double term = 0D;
    private final Double value = 0D;
    private final Timestamp creationDate = Timestamp.from(Instant.now());

    private CurvePoint model;
    private CurvePointDto dto;
    private List<CurvePoint> list = new ArrayList<>();
    private List<CurvePointDto> listDto = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.model = new CurvePoint(
                id,
                curveId,
                asOfDate,
                term,
                value,
                creationDate
        );
        this.dto = new CurvePointDto(
                id,
                curveId,
                asOfDate,
                term,
                value,
                creationDate
        );
        this.list.add(this.model);
        this.listDto.add(this.dto);
    }

    @Test
    public void findAllShouldReturnAListOfCurvePointDto() throws CurvePointNotFoundException {
        Mockito.when(this.repository.findAll()).thenReturn(this.list);
        Mockito.when(this.mapper.toDtoList(this.list)).thenReturn(this.listDto);
        List<CurvePointDto> toCompare = this.service.findAll();

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }

    @Test
    public void findAllShouldThrowCurvePointNotFoundException() throws CurvePointNotFoundException {
        String message = "Curve point not found";

        Mockito.when(this.repository.findAll()).thenReturn(null);
        CurvePointNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(CurvePointNotFoundException.class, () -> this.service.findAll(), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo( exception.getCode());
    }

    @Test
    public void createShouldReturnCurvePointDto() throws CurvePointNotFoundException, CurvePointIsNullException {
        Mockito.when(this.mapper.toModel(this.dto)).thenReturn(this.model);
        Mockito.when(this.repository.save(this.model)).thenReturn(this.model);
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        CurvePointDto toCompare = this.service.create(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(this.dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(this.dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(this.dto.hashCode());
    }

    @Test
    public void createShouldThrowParameterNotProvidedException() throws CurvePointNotFoundException {
        String message = "Curve point is null";

        CurvePointIsNullException exception = org.junit.jupiter.api.Assertions.assertThrows(CurvePointIsNullException.class, () -> this.service.create(null), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_ACCEPTABLE).isEqualTo( exception.getCode());
    }

    @Test
    public void findByIdShouldReturnACurvePointDto() throws ParameterNotProvidedException {
        Mockito.when(this.repository.findById(this.model.getId())).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        CurvePointDto toCompare = this.service.findById(this.dto.getId());

        Assertions.assertThat(toCompare).isEqualTo(this.dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(this.dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(this.dto.hashCode());
    }

    @Test
    public void findByIdShouldThrowParameterNotProvidedException() throws CurvePointNotFoundException {
        String message = "Parameter not provided";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.findById(null), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_ACCEPTABLE).isEqualTo( exception.getCode());
    }

    @Test
    public void updateShouldReturnCurvePointDto() throws ParameterNotProvidedException, CurvePointNotFoundException {
        Double term = 1D;
        CurvePointDto dtoToUpdate = new CurvePointDto(
                id,
                curveId,
                asOfDate,
                term,
                value,
                creationDate
        );
        CurvePoint model = new CurvePoint(
                id,
                curveId,
                asOfDate,
                term,
                value,
                creationDate
        );

        Mockito.when(this.mapper.update(this.dto, dtoToUpdate)).thenReturn(model);
        CurvePoint toCompare = this.mapper.update(this.dto, dtoToUpdate);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void updateShouldThrowParameterNotProvidedException() throws CurvePointNotFoundException {
        String message = "Parameter not provided";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.update(null, null), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_ACCEPTABLE).isEqualTo( exception.getCode());
    }

    @Test
    public void updateShouldThrowCurvePointNotFoundException() throws CurvePointNotFoundException {
        String message = "Curve point not found";

        Mockito.when(this.repository.findById(this.model.getId())).thenReturn(Optional.empty());
        CurvePointNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(CurvePointNotFoundException.class, () -> this.service.update(this.id, this.dto), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_FOUND).isEqualTo( exception.getCode());
    }

    @Test
    public void deleteByIdShouldCallRepositoryDeleteById() throws ParameterNotProvidedException, CurvePointNotFoundException {
        Mockito.doNothing().when(this.repository).deleteById(this.model.getId());
        this.service.deleteById(this.dto.getId());

        Mockito.verify(this.repository, Mockito.times(1)).deleteById(this.model.getId());
        Mockito.verifyNoMoreInteractions(this.repository);
    }

    @Test
    public void deleteByIdShouldThrowCurvePointNotFoundException() throws CurvePointNotFoundException {
        String message = "Parameter not provided";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.findById(null), message);

        Assertions.assertThat(message).isEqualTo( exception.getMessage());
        Assertions.assertThat(HttpStatus.NOT_ACCEPTABLE).isEqualTo( exception.getCode());
    }


}
