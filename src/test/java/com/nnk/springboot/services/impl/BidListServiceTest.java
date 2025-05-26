package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.mapper.impl.BidListMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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
    public void updateBidListShouldUpdateBidList() throws ParameterNotProvidedException {
        Integer id = 1;
        BidList bidList = new BidList();
        BidListDto bidListDto = new BidListDto();

        Mockito.when(this.repository.findById(id)).thenReturn(Optional.of(this.bid));
        Mockito.when(this.mapper.toDto(this.bid)).thenReturn(this.bidDto);
        Mockito.when(this.mapper.update(this.bidDto, bidListDto)).thenReturn(bidList);
        Mockito.when(this.repository.save(bidList)).thenReturn(bidList);
        Mockito.when(this.mapper.toDto(bidList)).thenReturn(bidListDto);
        BidListDto toCompare = service.update(id, bidListDto);

        Assertions.assertThat(toCompare).isEqualTo(bidListDto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bidListDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bidListDto.hashCode());
    }

    @Test
    public void deleteByIdBidListShouldDeleteByIdBidList() throws ParameterNotProvidedException {
        this.bidDto.setId(1);

        service.deleteById(bidDto.getId());
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
