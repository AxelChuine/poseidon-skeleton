package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.IService;
import com.nnk.springboot.services.mapper.impl.BidListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BidListService implements IService<BidListDto> {

    private final BidListRepository repository;

    private final BidListMapper mapper;

    public BidListService(BidListRepository repository, BidListMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public BidListDto create(final BidListDto bidList) {
        if (Objects.isNull(bidList)) {
            return null;
        }
        return this.mapper.toDto(repository.save(this.mapper.toModel(bidList)));
    }

    @Override
    public BidListDto update(final Integer id, final BidListDto bidList) throws ParameterNotProvidedException {
        if (Objects.isNull(id) || Objects.isNull(bidList)) {
            throw new ParameterNotProvidedException("The identifier or the bid was not provided. Please, try again.");
        }
        Optional<BidList> optional = this.repository.findById(id);
        return optional.map(list -> this.mapper.toDto(this.repository.save(this.mapper.update(this.mapper.toDto(list), bidList)))).orElse(null);
    }

    public void deleteById(final Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The bid was not correctly provided. Please, try again.");
        }
        repository.deleteById(id);
    }

    public List<BidListDto> findAll() {
        return this.mapper.toDtoList(repository.findAll());
    }

    public BidListDto findById(Integer id) {
        Optional<BidList> optional = repository.findById(id);
        return this.mapper.toDto(optional.orElse(null));
    }
}
