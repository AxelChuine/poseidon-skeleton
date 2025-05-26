package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.dtos.RuleNameDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RuleNameMapperTest {
    @InjectMocks
    private RuleNameMapper mapper;

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
    public void toDtoShouldReturnDto() {
        RuleNameDto toCompare = this.mapper.toDto(this.model);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void toModelShouldReturnAModel() {
        RuleName toCompare = this.mapper.toModel(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toDtoListShouldReturnADtoList() {
        List<RuleNameDto> listToCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(listToCompare).isEqualTo(listDto);
    }

    @Test
    public void updateShouldReturnAModel () {
        RuleName updated = new RuleName(
                id,
                "new name",
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );
        RuleNameDto updatedDto = new RuleNameDto(
                id,
                "new name",
                description,
                json,
                template,
                sqlStr,
                sqlPart
        );

        RuleName toCompare = this.mapper.update(this.dto, updatedDto);

        Assertions.assertThat(toCompare).isEqualTo(updated);
        Assertions.assertThat(toCompare.toString()).isEqualTo(updated.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(updated.hashCode());
    }
}
