package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TradeMapper implements IMapper<Trade, TradeDto> {
    @Override
    public TradeDto toDto(Trade model) {
        if (Objects.isNull(model)) {
            return null;
        }
        TradeDto dto = new TradeDto();
        dto.setId(model.getId());
        dto.setAccount(model.getAccount());
        dto.setType(model.getType());
        dto.setBuyQuantity(model.getBuyQuantity());
        dto.setSellQuantity(model.getSellQuantity());
        dto.setBuyPrice(model.getBuyPrice());
        dto.setTradeDate(model.getTradeDate());
        dto.setSecurity(model.getSecurity());
        dto.setStatus(model.getStatus());
        dto.setTrader(model.getTrader());
        dto.setBenchmark(model.getBenchmark());
        dto.setBook(model.getBook());
        dto.setId(model.getId());
        dto.setCreationName(model.getCreationName());
        dto.setCreationDate(model.getCreationDate());
        dto.setRevisionName(model.getRevisionName());
        dto.setRevisionDate(model.getRevisionDate());
        dto.setDealName(model.getDealName());
        dto.setDealType(model.getDealType());
        dto.setSourceListId(model.getSourceListId());
        dto.setSide(model.getSide());
        return dto;
    }

    @Override
    public Trade toModel(TradeDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        Trade model = new Trade();
        model.setId(dto.getId());
        model.setAccount(dto.getAccount());
        model.setType(dto.getType());
        model.setBuyQuantity(dto.getBuyQuantity());
        model.setSellQuantity(dto.getSellQuantity());
        model.setBuyPrice(dto.getBuyPrice());
        model.setTradeDate(dto.getTradeDate());
        model.setSecurity(dto.getSecurity());
        model.setStatus(dto.getStatus());
        model.setTrader(dto.getTrader());
        model.setBenchmark(dto.getBenchmark());
        model.setBook(dto.getBook());
        model.setId(dto.getId());
        model.setCreationName(dto.getCreationName());
        model.setCreationDate(dto.getCreationDate());
        model.setRevisionName(dto.getRevisionName());
        model.setRevisionDate(dto.getRevisionDate());
        model.setDealName(dto.getDealName());
        model.setDealType(dto.getDealType());
        model.setSourceListId(dto.getSourceListId());
        model.setSide(dto.getSide());
        return model;
    }

    @Override
    public Trade update(TradeDto dtoToUpdate, TradeDto dto) {
        if (Objects.isNull(dto) || Objects.isNull(dtoToUpdate) ) {
            return null;
        }
        Trade model = new Trade();
        model.setId(Objects.nonNull(dtoToUpdate.getId()) ? dtoToUpdate.getId() : Objects.isNull(dto.getId()) ? null : dto.getId());
        model.setAccount(Objects.nonNull(dto.getAccount()) ? dto.getAccount() : Objects.isNull(dtoToUpdate.getAccount()) ? null : dtoToUpdate.getAccount());
        model.setType(Objects.nonNull(dto.getType()) ? dto.getType() : Objects.isNull(dtoToUpdate.getType()) ? null : dtoToUpdate.getType());
        model.setBuyQuantity(Objects.nonNull(dto.getBuyQuantity()) ? dto.getBuyQuantity() : Objects.isNull(dtoToUpdate.getBuyQuantity()) ? null : dtoToUpdate.getBuyQuantity());
        model.setSellQuantity(Objects.nonNull(dto.getSellQuantity()) ? dto.getSellQuantity() : Objects.isNull(dtoToUpdate.getSellQuantity()) ? null : dtoToUpdate.getSellQuantity());
        model.setBuyPrice(Objects.nonNull(dto.getBuyPrice()) ? dto.getBuyPrice() : Objects.isNull(dtoToUpdate.getBuyPrice()) ? null : dtoToUpdate.getBuyPrice());
        model.setTradeDate(Objects.nonNull(dto.getTradeDate()) ? dto.getTradeDate() : Objects.isNull(dtoToUpdate.getTradeDate()) ? null : dtoToUpdate.getTradeDate());
        model.setSecurity(Objects.nonNull(dto.getSecurity()) ? dto.getSecurity() : Objects.isNull(dtoToUpdate.getSecurity()) ? null : dtoToUpdate.getSecurity());
        model.setStatus(Objects.nonNull(dto.getStatus()) ? dto.getStatus() : Objects.isNull(dtoToUpdate.getStatus()) ? null : dtoToUpdate.getStatus());
        model.setTrader(Objects.nonNull(dto.getTrader()) ? dto.getTrader() : Objects.isNull(dtoToUpdate.getTrader()) ? null : dtoToUpdate.getTrader());
        model.setBenchmark(Objects.nonNull(dto.getBenchmark()) ? dto.getBenchmark() : Objects.isNull(dtoToUpdate.getBenchmark()) ? null : dtoToUpdate.getBenchmark());
        model.setBook(Objects.nonNull(dto.getBook()) ? dto.getBook() : Objects.isNull(dtoToUpdate.getBook()) ? null : dtoToUpdate.getBook());
        model.setCreationName(Objects.nonNull(dto.getCreationName()) ? dto.getCreationName() : Objects.isNull(dtoToUpdate.getCreationName()) ? null : dtoToUpdate.getCreationName());
        model.setCreationDate(Objects.nonNull(dto.getCreationDate()) ? dto.getCreationDate() : Objects.isNull(dtoToUpdate.getCreationDate()) ? null : dtoToUpdate.getCreationDate());
        model.setRevisionName(Objects.nonNull(dto.getRevisionName()) ? dto.getRevisionName() : Objects.isNull(dtoToUpdate.getRevisionName()) ? null : dtoToUpdate.getRevisionName());
        model.setRevisionDate(Objects.nonNull(dto.getRevisionDate()) ? dto.getRevisionDate() : Objects.isNull(dtoToUpdate.getRevisionDate()) ? null : dtoToUpdate.getRevisionDate());
        model.setDealName(Objects.nonNull(dto.getDealName()) ? dto.getDealName() : Objects.isNull(dtoToUpdate.getDealName()) ? null : dtoToUpdate.getDealName());
        model.setDealType(Objects.nonNull(dto.getDealType()) ? dto.getDealType() : Objects.isNull(dtoToUpdate.getDealType()) ? null : dtoToUpdate.getDealType());
        model.setSourceListId(Objects.nonNull(dto.getSourceListId()) ? dto.getSourceListId() : Objects.isNull(dtoToUpdate.getSourceListId()) ? null : dtoToUpdate.getSourceListId());
        model.setSide(Objects.nonNull(dto.getSide()) ? dto.getSide() : Objects.isNull(dtoToUpdate.getSide()) ? null : dtoToUpdate.getSide());
        return model;
    }

    @Override
    public List<TradeDto> toDtoList(List<Trade> modelList) {
        List<TradeDto> dtoList = new ArrayList<>();
        for (Trade t : modelList) {
            dtoList.add(toDto(t));
        }
        return dtoList;
    }
}
