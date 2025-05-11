package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListService {

    private final BidListRepository repository;

    public BidListService(BidListRepository repository) {
        this.repository = repository;
    }

    public BidList create(final BidList bidList) {
        return repository.save(bidList);
    }

    public BidList update(final BidList bidList) {
        return repository.save(bidList);
    }

    public void delete(final Integer id) {
        repository.deleteById(id);
    }

    public List<BidList> findAll() {
        return repository.findAll();
    }
}
