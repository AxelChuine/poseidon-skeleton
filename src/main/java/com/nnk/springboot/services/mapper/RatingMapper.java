package com.nnk.springboot.services.mapper;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RatingMapper {

    public RatingDto toDto(Rating model) {
        if (Objects.isNull(model)) {
            return null;
        }
        RatingDto dto = new RatingDto();
        dto.setId(model.getId());
        dto.setMoodysRating(model.getMoodysRating());
        dto.setSandPRating(model.getSandPRating());
        dto.setFitchRating(model.getFitchRating());
        dto.setOrderNumber(model.getOrderNumber());
        return dto;
    }

    public List<RatingDto> toDtoList(List<Rating> list) {
        List<RatingDto> dtoList = new ArrayList<>();
        for (Rating r : list) {
            dtoList.add(toDto(r));
        }
        return dtoList;
    }

    public Rating toModel(RatingDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        Rating model = new Rating();
        model.setId(dto.getId());
        model.setMoodysRating(dto.getMoodysRating());
        model.setSandPRating(dto.getSandPRating());
        model.setFitchRating(dto.getFitchRating());
        model.setOrderNumber(dto.getOrderNumber());
        return model;
    }
}
