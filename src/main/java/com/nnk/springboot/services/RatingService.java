package com.nnk.springboot.services;

import com.nnk.springboot.dtos.RatingDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.RatingListNullPointerException;
import com.nnk.springboot.exceptions.RatingNullPointerException;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.mapper.RatingMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RatingService {
    private final RatingRepository repository;

    private final RatingMapper mapper;

    public RatingService(RatingRepository repository, RatingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RatingDto> findAll() {
        List<RatingDto> list = this.mapper.toDtoList(this.repository.findAll());
        if (Objects.isNull(list) || list.isEmpty()) {
            throw new RatingListNullPointerException();
        }
        return list;
    }

    public RatingDto create(RatingDto rating) {
        if (Objects.isNull(rating)) {
            throw new RatingNullPointerException();
        }
        RatingDto dto = this.mapper.toDto(this.repository.save(this.mapper.toModel(rating)));
        if (Objects.isNull(dto)) {
            throw new RatingNullPointerException("The rating could not be created. Please, try again.", HttpStatus.BAD_REQUEST);
        }
        return dto;
    }

    public RatingDto findById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided. Please, try again.");
        }
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }

    public RatingDto update(RatingDto rating) {
        if (Objects.isNull(rating)) {
            throw new RatingNullPointerException();
        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(rating)));
    }

    public void deleteById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided, please try again.");
        }
        this.repository.deleteById(id);
    }
}
