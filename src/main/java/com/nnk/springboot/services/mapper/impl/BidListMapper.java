package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.services.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BidListMapper implements IMapper<BidList, BidListDto> {


    @Override
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

    @Override
    public List<BidListDto> toDtoList(List<BidList> list) {
        List<BidListDto> dtoList = new ArrayList<>();
        for (BidList bid : list) {
            dtoList.add(toDto(bid));
        }
        return dtoList;
    }

    @Override
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

    @Override
    public BidList update(BidListDto dtoToUpdate, BidListDto dto) {
        if (Objects.isNull(dtoToUpdate) || Objects.isNull(dto)) {
            return null;
        }
        BidList model = new BidList();
        model.setId(dtoToUpdate.getId());
        model.setAccount(Objects.isNull(dto.getAccount()) ? Objects.isNull(dtoToUpdate.getAccount()) ? null : dtoToUpdate.getAccount() : dto.getAccount());
        model.setType(Objects.isNull(dto.getType()) ? Objects.isNull(dtoToUpdate.getType()) ? null : dtoToUpdate.getType() : dto.getType());
        model.setBidQuantity(Objects.isNull(dto.getBidQuantity()) ? Objects.isNull(dtoToUpdate.getBidQuantity()) ? null : dtoToUpdate.getBidQuantity() : dto.getBidQuantity());
        model.setBid(Objects.isNull(dto.getBid()) ? Objects.isNull(dtoToUpdate.getBid()) ? null : dtoToUpdate.getBid() : dto.getBid());
        model.setAsk(Objects.isNull(dto.getAsk()) ? Objects.isNull(dtoToUpdate.getAsk()) ? null : dtoToUpdate.getAsk() : dto.getAsk());
        model.setBenchmark(Objects.isNull(dto.getBenchmark()) ? Objects.isNull(dtoToUpdate.getBenchmark()) ? null : dtoToUpdate.getBenchmark() : dto.getBenchmark());
        model.setBidListDate(Objects.isNull(dto.getBidListDate()) ? Objects.isNull(dtoToUpdate.getBidListDate()) ? null : dtoToUpdate.getBidListDate() : dto.getBidListDate());
        model.setCommentary(Objects.isNull(dto.getCommentary()) ? Objects.isNull(dtoToUpdate.getCommentary()) ? null : dtoToUpdate.getCommentary() : dto.getCommentary());
        model.setSecurity(Objects.isNull(dto.getSecurity()) ? Objects.isNull(dtoToUpdate.getSecurity()) ? null : dtoToUpdate.getSecurity() : dto.getSecurity());
        model.setStatus(Objects.isNull(dto.getStatus()) ? Objects.isNull(dtoToUpdate.getStatus()) ? null : dtoToUpdate.getStatus() : dto.getStatus());
        model.setTrader(Objects.isNull(dto.getTrader()) ? Objects.isNull(dtoToUpdate.getTrader()) ? null : dtoToUpdate.getTrader() : dto.getTrader());
        model.setBook(Objects.isNull(dto.getBook()) ? Objects.isNull(dtoToUpdate.getBook()) ? null : dtoToUpdate.getBook() : dto.getBook());
        model.setCreationName(Objects.isNull(dto.getCreationName()) ? Objects.isNull(dtoToUpdate.getCreationName()) ? null : dtoToUpdate.getCreationName() : dto.getCreationName());
        model.setCreationDate(Objects.isNull(dto.getCreationDate()) ? Objects.isNull(dtoToUpdate.getCreationDate()) ? null : dtoToUpdate.getCreationDate() : dto.getCreationDate());
        model.setRevisionName(Objects.isNull(dto.getRevisionName()) ? Objects.isNull(dtoToUpdate.getRevisionName()) ? null : dtoToUpdate.getRevisionName() : dto.getRevisionName());
        model.setRevisionDate(Objects.isNull(dto.getRevisionDate()) ? Objects.isNull(dtoToUpdate.getRevisionDate()) ? null : dtoToUpdate.getRevisionDate() : dto.getRevisionDate());
        model.setDealName(Objects.isNull(dto.getDealName()) ? Objects.isNull(dtoToUpdate.getDealName()) ? null : dtoToUpdate.getDealName() : dto.getDealName());
        model.setDealType(Objects.isNull(dto.getDealType()) ? Objects.isNull(dtoToUpdate.getDealType()) ? null : dtoToUpdate.getDealType() : dto.getDealType());
        model.setSourceListId(Objects.isNull(dto.getSourceListId()) ? Objects.isNull(dtoToUpdate.getSourceListId()) ? null : dtoToUpdate.getSourceListId() : dto.getSourceListId());
        model.setSide(Objects.isNull(dto.getSide()) ? Objects.isNull(dtoToUpdate.getSide()) ? null : dtoToUpdate.getSide() : dto.getSide());
        return model;
    }
}
