package com.nnk.springboot.services.mapper;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CurvePointMapper {

    public CurvePointDto toDto(final CurvePoint model) {
        if (model == null) {
            return null;
        }
        CurvePointDto dto = new CurvePointDto();
        dto.setId(model.getId());
        dto.setCurveId(model.getCurveId());
        dto.setAsOfDate(model.getAsOfDate());
        dto.setTerm(model.getTerm());
        dto.setValue(model.getValue());
        dto.setCreationDate(model.getCreationDate());
        return dto;
    }

    public List<CurvePointDto> toDtoList(List<CurvePoint> modelList) {
        List<CurvePointDto> dtoList = new ArrayList<>();
        for (CurvePoint cp : modelList) {
            dtoList.add(toDto(cp));
        }
        return dtoList;
    }

    public CurvePoint toModel(CurvePointDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        CurvePoint model = new CurvePoint();
        model.setId(dto.getId());
        model.setCurveId(dto.getCurveId());
        model.setAsOfDate(dto.getAsOfDate());
        model.setTerm(dto.getTerm());
        model.setValue(dto.getValue());
        model.setCreationDate(dto.getCreationDate());
        return model;
    }
}
