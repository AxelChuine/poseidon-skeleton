package com.nnk.springboot.services;

import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.mapper.RuleNameMapper;
import org.springframework.stereotype.Service;

@Service
public class RuleNameService {
    private final RuleNameRepository repository;

    private final RuleNameMapper mapper;
}
