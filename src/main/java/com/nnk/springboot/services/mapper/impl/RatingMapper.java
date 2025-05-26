package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RatingMapper implements IMapper<Rating, RatingDto> {

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

    public Rating update(final RatingDto toUpdateDto, final RatingDto rating) {
        if (Objects.isNull(toUpdateDto) || Objects.isNull(rating)) {
            return null;
        }
        Rating model = new Rating();
        model.setId(Objects.nonNull(toUpdateDto.getId()) ? toUpdateDto.getId() : Objects.isNull(rating.getId()) ? null : rating.getId());
        model.setMoodysRating(Objects.nonNull(rating.getMoodysRating()) ? rating.getMoodysRating() : Objects.isNull(toUpdateDto.getMoodysRating()) ? null : toUpdateDto.getMoodysRating());
        model.setSandPRating(Objects.nonNull(rating.getSandPRating()) ? rating.getSandPRating() : Objects.isNull(toUpdateDto.getSandPRating()) ? null : toUpdateDto.getSandPRating());
        model.setFitchRating(Objects.nonNull(rating.getFitchRating()) ? rating.getFitchRating() : Objects.isNull(toUpdateDto.getFitchRating()) ? null : toUpdateDto.getFitchRating());
        model.setOrderNumber(Objects.nonNull(rating.getOrderNumber()) ? rating.getOrderNumber() : Objects.isNull(toUpdateDto.getOrderNumber()) ? null : toUpdateDto.getOrderNumber());
        return model;
    }
}
