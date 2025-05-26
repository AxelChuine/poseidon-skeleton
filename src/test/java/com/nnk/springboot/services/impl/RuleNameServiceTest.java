package com.nnk.springboot.services.impl;

import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.mapper.impl.RuleNameMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {
    @InjectMocks
    private RuleNameService service;

    @Mock
    private RuleNameMapper mapper;

    @Mock
    private RuleNameRepository repository;
}
