package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.IService;
import com.nnk.springboot.services.mapper.impl.TradeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TradeService implements IService<TradeDto> {
    private final TradeRepository repository;

    private final TradeMapper mapper;

    public TradeService(TradeRepository repository, TradeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TradeDto create(TradeDto dto) throws ParameterNotProvidedException {
        if (Objects.isNull(dto)) {
            throw new ParameterNotProvidedException("The trade was not provided. Please, try again.");
        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(dto)));
    }

    @Override
    public TradeDto update(Integer id, TradeDto dto) throws ParameterNotProvidedException {
        if (Objects.isNull(id) || Objects.isNull(dto)) {
            throw new ParameterNotProvidedException("The identifier or the trade was not provided. Please, try again.");
        }
        Optional<Trade> optional = this.repository.findById(id);
        return optional.map(trade -> this.mapper.toDto(this.repository.save(this.mapper.update(this.mapper.toDto(trade), dto)))).orElse(null);
    }

    @Override
    public List<TradeDto> findAll() {
        return this.mapper.toDtoList(this.repository.findAll());
    }

    @Override
    public TradeDto findById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided. Please, try again.");
        }
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided. Please, try again.");
        }
        this.repository.deleteById(id);
    }
}
