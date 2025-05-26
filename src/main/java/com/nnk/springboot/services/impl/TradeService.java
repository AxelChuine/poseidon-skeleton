package com.nnk.springboot.services.impl;

import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService implements IService<TradeDto> {
    @Override
    public TradeDto create(TradeDto dto) throws ParameterNotProvidedException {
        return null;
    }

    @Override
    public TradeDto update(Integer id, TradeDto dto) throws ParameterNotProvidedException {
        return null;
    }

    @Override
    public List<TradeDto> findAll() {
        return List.of();
    }

    @Override
    public TradeDto findById(Integer id) throws ParameterNotProvidedException {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws ParameterNotProvidedException {

    }
}
