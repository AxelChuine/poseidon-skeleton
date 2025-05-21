package com.nnk.springboot.services.mapper;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BidListMapper {


    public BidListDto toDto(BidList model) {
        if (Objects.isNull(model)) {
            return null;
        }
        BidListDto dto = new BidListDto();
        dto.setId(model.getId());
        dto.setAccount(model.getAccount());
        dto.setType(model.getType());
        dto.setBidQuantity(model.getBidQuantity());
        dto.setAskQuantity(model.getAskQuantity());
        dto.setBid(model.getBid());
        dto.setAsk(model.getAsk());
        dto.setBenchmark(model.getBenchmark());
        dto.setBidListDate(model.getBidListDate());
        dto.setCommentary(model.getCommentary());
        dto.setSecurity(model.getSecurity());
        dto.setStatus(model.getStatus());
        dto.setTrader(model.getTrader());
        dto.setBook(model.getBook());
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

    public List<BidListDto> toDtoList(List<BidList> list) {
        List<BidListDto> dtoList = new ArrayList<>();
        for (BidList bid : list) {
            dtoList.add(toDto(bid));
        }
        return dtoList;
    }

    public BidList toModel(BidListDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        BidList model = new BidList();
        model.setId(dto.getId());
        model.setAccount(dto.getAccount());
        model.setType(dto.getType());
        model.setBidQuantity(dto.getBidQuantity());
        model.setAskQuantity(dto.getAskQuantity());
        model.setBid(dto.getBid());
        model.setAsk(dto.getAsk());
        model.setBenchmark(dto.getBenchmark());
        model.setBidListDate(dto.getBidListDate());
        model.setCommentary(dto.getCommentary());
        model.setSecurity(dto.getSecurity());
        model.setStatus(dto.getStatus());
        model.setTrader(dto.getTrader());
        model.setBook(dto.getBook());
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
}
