package com.nnk.springboot.services.mappers.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import com.nnk.springboot.services.CurvePointService;
import com.nnk.springboot.services.mapper.impl.CurvePointMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CurvePointMapperTest {
    @InjectMocks
    private CurvePointMapper mapper;

    @Mock
    private CurvePointService service;

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
    public void toDtoShouldReturnDto() {
        CurvePointDto toCompare = this.mapper.toDto(this.model);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void toModelShouldReturnModel() {
        CurvePoint toCompare = this.mapper.toModel(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toDtoListShouldReturnDtoList() {
        List<CurvePointDto> toCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }

    @Test
    public void tuUpdateShouldReturnModel() {
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
        CurvePoint toCompare = this.mapper.update(this.dto, dtoToUpdate);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }
}
