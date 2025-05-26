package com.nnk.springboot.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeDto {
    private Integer id;

    @NotNull
    private String account;

    @NotNull
    private String type;
    private Double buyQuantity;
    private Double sellQuantity;
    private Double buyPrice;
    private Double sellPrice;
    private Instant tradeDate;
    private String security;
    private String status;
    private String trader;
    private String benchmark;
    private String book;
    private String creationName;
    private LocalDateTime creationDate;
    private String revisionName;
    private Instant revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    public TradeDto(Integer id, String account, String type) {
        this.id = id;
        this.account = account;
        this.type = type;
    }
}
