package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.mapper.BidListMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {
    @InjectMocks
    private BidListService service;

    @Mock
    private BidListRepository repository;

    @Mock
    private BidListMapper mapper;

    private final BidList bid = new BidList("Account Test", "Type Test", 10d);
    private final BidListDto bidDto = new BidListDto("Account Test", "Type Test", 10d);

    @Test
    public void createShouldCreateBidList() {
        Mockito.when(this.mapper.toModel(bidDto)).thenReturn(bid);
        Mockito.when(repository.save(bid)).thenReturn(bid);
        Mockito.when(this.mapper.toDto(bid)).thenReturn(this.bidDto);
        BidListDto toCompare = service.create(bidDto);

        Assertions.assertThat(toCompare).isEqualTo(bidDto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bidDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bidDto.hashCode());
    }

    @Test
    public void updateBidListShouldUpdateBidList() {
        Mockito.when(repository.save(bid)).thenReturn(bid);
        BidList toCompare = service.update(bid);

        Assertions.assertThat(toCompare).isEqualTo(bid);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bid.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bid.hashCode());
    }

    @Test
    public void deleteBidListShouldDeleteBidList() throws ParameterNotProvidedException {
        this.bidDto.setId(1);

        service.delete(bidDto.getId());
        Mockito.verify(repository, Mockito.times(1)).deleteById(bidDto.getId());
    }

    @Test
    public void findAllBidListShouldReturnAllBidList() {
        List<BidList> bidList = List.of(bid);
        List<BidListDto> listDto = List.of(bidDto);

        Mockito.when(repository.findAll()).thenReturn(bidList);
        Mockito.when(mapper.toDtoList(bidList)).thenReturn(listDto);
        List<BidListDto> toCompare = this.service.findAll();

        Assertions.assertThat(toCompare).containsExactly(bidDto);
        Assertions.assertThat(toCompare).isNotEmpty();
        Assertions.assertThat(toCompare).isNotNull();
        Assertions.assertThat(toCompare.toString()).isEqualTo(listDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(listDto.hashCode());
    }
}
