package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.mapper.BidListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BidListService {

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

    public BidList update(final BidList bidList) {
        return repository.save(bidList);
    }

    public void delete(final Integer id) throws ParameterNotProvidedException {
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
