package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {
    @InjectMocks
    private BidListService service;

    @Mock
    private BidListRepository repository;

    private final BidList bid = new BidList("Account Test", "Type Test", 10d);

    @Test
    public void createShouldCreateBidList() {
        Mockito.when(repository.save(bid)).thenReturn(bid);
        BidList toCompare = service.create(bid);

        Assertions.assertThat(toCompare).isEqualTo(bid);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bid.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bid.hashCode());
    }
}
