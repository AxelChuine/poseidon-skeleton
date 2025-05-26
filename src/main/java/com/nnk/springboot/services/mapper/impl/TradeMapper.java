package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeMapper implements IMapper<Trade, TradeDto> {
    @Override
    public TradeDto toDto(Trade model) {
        return null;
    }

    @Override
    public Trade toModel(TradeDto dto) {
        return null;
    }

    @Override
    public Trade update(TradeDto dtoToUpdate, TradeDto dto) {
        return null;
    }

    @Override
    public List<TradeDto> toDtoList(List<Trade> modelList) {
        return List.of();
    }
}
