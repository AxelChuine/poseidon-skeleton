package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CurvePointMapper implements IMapper<CurvePoint, CurvePointDto> {

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


    public CurvePoint update(CurvePointDto toUpdate, CurvePointDto update) {
        if (Objects.isNull(toUpdate) || Objects.isNull(update)) {
            return null;
        }
        Timestamp date = Timestamp.from(Instant.now());
        CurvePoint model = new CurvePoint();
        model.setId(Objects.nonNull(toUpdate.getId()) ? toUpdate.getId() : Objects.isNull(update.getId()) ? null : update.getId());
        model.setCurveId(Objects.nonNull(update.getCurveId()) ? update.getCurveId() : Objects.isNull(toUpdate.getCurveId()) ? null : toUpdate.getCurveId());
        model.setAsOfDate(Objects.nonNull(update.getAsOfDate()) ? update.getAsOfDate() : Objects.isNull(toUpdate.getAsOfDate()) ? date : toUpdate.getAsOfDate());
        model.setTerm(Objects.nonNull(update.getTerm()) ? update.getTerm() : Objects.isNull(toUpdate.getTerm()) ? null : toUpdate.getTerm());
        model.setValue(Objects.nonNull(update.getValue()) ? update.getValue() : Objects.isNull(toUpdate.getValue()) ? null : toUpdate.getValue());
        model.setCreationDate(Objects.nonNull(update.getCreationDate()) ? update.getCreationDate() : Objects.isNull(toUpdate.getCreationDate()) ? date : toUpdate.getCreationDate());
        return model;
    }
}
