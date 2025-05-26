package com.nnk.springboot.services.impl;

import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.mapper.impl.RuleNameMapper;
import org.springframework.stereotype.Service;

@Service
public class RuleNameService {
    private final RuleNameRepository repository;

    private final RuleNameMapper mapper;

    public RuleNameService(RuleNameRepository repository, RuleNameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
