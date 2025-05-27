package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.mapper.impl.TradeMapper;
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
public class TradeServiceTest {
    @InjectMocks
    private TradeService service;

    @Mock
    private TradeMapper mapper;

    @Mock
    private TradeRepository repository;

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
    public void findAllShouldReturnAListOfDto () {
        Mockito.when(this.repository.findAll()).thenReturn(this.list);
        Mockito.when(this.mapper.toDtoList(this.list)).thenReturn(this.listDto);
        List<TradeDto> toCompare = this.service.findAll();

        Assertions.assertThat(toCompare).isEqualTo(this.listDto);
    }

    @Test
    public void findByIdShouldReturnADto () throws ParameterNotProvidedException {
        Mockito.when(this.repository.findById(this.id)).thenReturn(java.util.Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        TradeDto toCompare = this.service.findById(this.id);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void findByIdShouldThrowParameterNotProvidedException () {
        String message = "The identifier was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.findById(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    public void updateShouldReturnADto () throws ParameterNotProvidedException {
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

        Mockito.when(this.repository.findById(this.id)).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        Mockito.when(this.mapper.update(this.dto, updatedDto)).thenReturn(updated);
        Mockito.when(this.repository.save(updated)).thenReturn(updated);
        Mockito.when(this.mapper.toDto(updated)).thenReturn(updatedDto);
        TradeDto toCompare = this.service.update(this.id, updatedDto);

        Assertions.assertThat(toCompare).isEqualTo(updatedDto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(updatedDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(updatedDto.hashCode());
    }

    @Test
    public void updateShouldThrowParameterNotProvidedException () {
        String message = "The identifier or the trade was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.update(null, null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    public void createShouldReturnADto () throws ParameterNotProvidedException {
        Mockito.when(this.mapper.toModel(this.dto)).thenReturn(this.model);
        Mockito.when(this.repository.save(this.model)).thenReturn(this.model);
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        TradeDto toCompare = this.service.create(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void createShouldThrowParameterNotProvidedException () {
        String message = "The trade was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.create(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    public void deleteByIdShouldDeleteById () throws ParameterNotProvidedException {
        this.service.deleteById(this.id);
        Mockito.verify(this.repository, Mockito.times(1)).deleteById(this.id);
    }

    @Test
    public void deleteByIdShouldThrowParameterNotProvidedException () {
        String message = "The identifier was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.deleteById(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }
}
