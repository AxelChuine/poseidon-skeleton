package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.mapper.impl.TradeMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {
    @InjectMocks
    private TradeService service;

    @Mock
    private TradeMapper mapper;

    @Mock
    private TradeRepository repository;

    private final Trade trade = new Trade();
    private final TradeDto tradeDto = new TradeDto();
}
