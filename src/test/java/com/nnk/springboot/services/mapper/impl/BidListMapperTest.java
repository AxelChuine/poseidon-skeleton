package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BidListMapperTest {

    @InjectMocks
    private BidListMapper mapper;

    private final Integer id = 1;
    private final String account = "account";
    private final String type = "type";
    private final Double bidQuantity = 0D;
    private final Double askQuantity = 0D;
    private final Double bid = 0D;
    private final Double ask = 0D;
    private final String benchmark = "benchmark";
    private final Timestamp bidListDate = Timestamp.valueOf("2022-01-01 00:00:00");
    private final String commentary = "commentary";
    private final String security = "security";
    private final String status = "status";
    private final String trader = "trader";
    private final String book = "book";
    private final String creationName = "creationName";
    private final Timestamp creationDate = Timestamp.valueOf("2022-01-01 00:00:00");
    private final String revisionName = "revisionName";
    private final Timestamp revisionDate = Timestamp.valueOf("2022-01-01 00:00:00");
    private final String dealName = "dealName";
    private final String dealType = "dealType";
    private final String sourceListId = "sourceListId";
    private final String side = "side";

    private BidList bidList;
    private BidListDto bidListDto;
    private List<BidList> list = new ArrayList<>();
    private List<BidListDto> listDto = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.bidList = new BidList(
                id,
                account,
                type,
                bidQuantity,
                askQuantity,
                bid,
                ask,
                benchmark,
                bidListDate,
                commentary,
                security,
                status,
                trader,
                book,
                creationName,
                creationDate,
                revisionName,
                revisionDate,
                dealName,
                dealType,
                sourceListId,
                side
        );
        this.bidListDto = new BidListDto(
                id,
                account,
                type,
                bidQuantity,
                askQuantity,
                bid,
                ask,
                benchmark,
                bidListDate,
                commentary,
                security,
                status,
                trader,
                book,
                creationName,
                creationDate,
                revisionName,
                revisionDate,
                dealName,
                dealType,
                sourceListId,
                side
        );
        this.list.add(this.bidList);
        this.listDto.add(this.bidListDto);
    }

    @Test
    public void toDtoShouldReturnDto() {
        BidListDto toCompare = this.mapper.toDto(this.bidList);

        Assertions.assertThat(toCompare).isEqualTo(bidListDto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bidListDto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bidListDto.hashCode());
    }

    @Test
    public void toModelShouldReturnModel() {
        BidList toCompare = this.mapper.toModel(this.bidListDto);

        Assertions.assertThat(toCompare).isEqualTo(bidList);
        Assertions.assertThat(toCompare.toString()).isEqualTo(bidList.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(bidList.hashCode());
    }

    @Test
    public void toDtoListShouldReturnDtoList() {
        List<BidListDto> toCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }
}
