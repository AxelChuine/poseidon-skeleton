package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TradeMapperTest {
    @InjectMocks
    private TradeMapper mapper;

    private final Integer id = 1;
    private final String account = "account";
    private final String type = "type";

    private Trade model;
    private TradeDto dto;
    private List<Trade> list = new ArrayList<>();
    private List<TradeDto> listDto = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.model = new Trade(
                this.id,
                this.account,
                this.type
        );
        this.dto = new TradeDto(
                this.id,
                this.account,
                this.type
        );
        this.list = List.of(this.model);
        this.listDto = List.of(this.dto);
    }

    @Test
    public void toDtoShouldReturnDto() {
        TradeDto toCompare = this.mapper.toDto(this.model);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void toModelShouldReturnModel() {
        Trade toCompare = this.mapper.toModel(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toDtoListShouldReturnDtoList() {
        List<TradeDto> listToCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(listToCompare).isEqualTo(this.listDto);
    }

    @Test
    public void updateShouldReturnModel() {
        String type = "new type";
        Trade updated = new Trade(
                this.id,
                this.account,
                type
        );
        TradeDto updatedDto = new TradeDto(
                this.id,
                this.account,
                type
        );
        Trade toCompare = this.mapper.update(this.dto, updatedDto);

        Assertions.assertThat(toCompare).isEqualTo(updated);
        Assertions.assertThat(toCompare.toString()).isEqualTo(updated.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(updated.hashCode());
    }
}
