package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.dtos.RuleNameDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.mapper.impl.RuleNameMapper;
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
public class RuleNameServiceTest {
    @InjectMocks
    private RuleNameService service;

    @Mock
    private RuleNameMapper mapper;

    @Mock
    private RuleNameRepository repository;

    private final Integer id = 1;
    private final String name = "name";
    private final String description = "description";
    private final String json = "json";
    private final String template = "template";
    private final String sqlStr = "sqlStr";
    private final String sqlPart = "part";

    private RuleName model;
    private RuleNameDto dto;
    private List<RuleName> list = new ArrayList<>();
    private List<RuleNameDto> listDto = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.model = new RuleName(
                id,
                name,
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );
        this.dto = new RuleNameDto(
                id,
                name,
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );
        this.list.add(this.model);
        this.listDto.add(this.dto);
    }

    @Test
    public void createShouldCreateRuleNameDto() throws ParameterNotProvidedException {
        Mockito.when(this.mapper.toModel(this.dto)).thenReturn(this.model);
        Mockito.when(this.repository.save(this.model)).thenReturn(this.model);
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        RuleNameDto toCompare = this.service.create(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void createShouldThrowParameterNotProvidedException () {
        String message = "The rule name was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.create(null), message);

        Assertions.assertThat(exception.getMessage()).isEqualTo(message);
        Assertions.assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    public void findByIdShouldReturnADto() throws ParameterNotProvidedException {
        Mockito.when(this.repository.findById(this.id)).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        RuleNameDto toCompare = this.service.findById(this.id);

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
    public void findAllSHouldReturnAListOfDto () {
        Mockito.when(this.mapper.toDtoList(this.repository.findAll())).thenReturn(this.listDto);
        List<RuleNameDto> listToCompare = this.service.findAll();

        Assertions.assertThat(this.listDto).isEqualTo(listToCompare);
    }

    @Test
    public void updateShouldReturnADto () throws ParameterNotProvidedException {
        String name = "new name";
        RuleName updated = new RuleName(
                id,
                name,
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );
        RuleNameDto updatedDto = new RuleNameDto(
                id,
                name,
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );
        Mockito.when(this.repository.findById(this.id)).thenReturn(Optional.of(this.model));
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        Mockito.when(this.mapper.update(this.dto, updatedDto)).thenReturn(updated);
        Mockito.when(this.repository.save(updated)).thenReturn(updated);
        Mockito.when(this.mapper.toDto(updated)).thenReturn(updatedDto);
        RuleNameDto toCompare = this.service.update(this.id, updatedDto);
    }

    @Test
    public void updateShouldThrowParameterNotProvidedException () {
        String message = "The identifier or the rule name was not provided. Please, try again.";

        ParameterNotProvidedException exception = org.junit.jupiter.api.Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.update(null, null), message);

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
