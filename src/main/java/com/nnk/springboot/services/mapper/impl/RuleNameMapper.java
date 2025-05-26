package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.dtos.RuleNameDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RuleNameMapper implements IMapper<RuleName, RuleNameDto> {
    @Override
    public RuleNameDto toDto(RuleName model) {
        if (Objects.isNull(model)) {
            return null;
        }
        RuleNameDto dto = new RuleNameDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setJson(model.getJson());
        dto.setTemplate(model.getTemplate());
        dto.setSqlStr(model.getSqlStr());
        dto.setSqlPart(model.getSqlPart());
        return dto;
    }

    @Override
    public RuleName toModel(RuleNameDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        RuleName model = new RuleName();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setJson(dto.getJson());
        model.setTemplate(dto.getTemplate());
        model.setSqlStr(dto.getSqlStr());
        model.setSqlPart(dto.getSqlPart());
        return model;
    }

    @Override
    public RuleName update(RuleNameDto dtoToUpdate, RuleNameDto dto) {
        if (Objects.isNull(dtoToUpdate) || Objects.isNull(dto)) {
            return null;
        }
        RuleName model = new RuleName();
        model.setId(Objects.isNull(dtoToUpdate.getId()) ? Objects.isNull(dto.getId()) ? null : dto.getId() : dtoToUpdate.getId());
        model.setName(Objects.isNull(dto.getName()) ? Objects.isNull(dtoToUpdate.getName()) ? "" : dtoToUpdate.getName() : dto.getName());
        model.setDescription(Objects.isNull(dto.getDescription()) ? Objects.isNull(dtoToUpdate.getDescription()) ? null : dtoToUpdate.getDescription() : dto.getDescription());
        model.setJson(Objects.isNull(dto.getJson()) ? Objects.isNull(dtoToUpdate.getJson()) ? null : dtoToUpdate.getJson() : dto.getJson());
        model.setTemplate(Objects.isNull(dto.getTemplate()) ? Objects.isNull(dtoToUpdate.getTemplate()) ? null : dtoToUpdate.getTemplate() : dto.getTemplate());
        model.setSqlStr(Objects.isNull(dto.getSqlStr()) ? Objects.isNull(dtoToUpdate.getSqlStr()) ? null : dtoToUpdate.getSqlStr() : dto.getSqlStr());
        model.setSqlPart(Objects.isNull(dto.getSqlPart()) ? Objects.isNull(dtoToUpdate.getSqlPart()) ? null : dtoToUpdate.getSqlPart() : dto.getSqlPart());
        return model;
    }

    @Override
    public List<RuleNameDto> toDtoList(List<RuleName> modelList) {
        if (Objects.isNull(modelList) || modelList.isEmpty()) {
            return null;
        }
        List<RuleNameDto> dtoList = new ArrayList<>();
        for (RuleName rn : modelList) {
            dtoList.add(toDto(rn));
        }
        return dtoList;
    }
}
