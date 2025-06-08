package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "Trade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "account", nullable = false, length = 30)
    private String account;

    @Size(max = 30)
    @NotNull
    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @Column(name = "buy_quantity")
    private Double buyQuantity;

    @Column(name = "sell_quantity")
    private Double sellQuantity;

    @Column(name = "buy_price")
    private Double buyPrice;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "trade_date")
    private Timestamp tradeDate;

    @Size(max = 125)
    @Column(name = "security", length = 125)
    private String security;

    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    @Size(max = 125)
    @Column(name = "trader", length = 125)
    private String trader;

    @Size(max = 125)
    @Column(name = "benchmark", length = 125)
    private String benchmark;

    @Size(max = 125)
    @Column(name = "book", length = 125)
    private String book;

    @Size(max = 125)
    @Column(name = "creation_name", length = 125)
    private String creationName;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Size(max = 125)
    @Column(name = "revision_name", length = 125)
    private String revisionName;

    @Column(name = "revision_date")
    private Timestamp revisionDate;

    @Size(max = 125)
    @Column(name = "deal_name", length = 125)
    private String dealName;

    @Size(max = 125)
    @Column(name = "deal_type", length = 125)
    private String dealType;

    @Size(max = 125)
    @Column(name = "source_list_id", length = 125)
    private String sourceListId;

    @Size(max = 125)
    @Column(name = "side", length = 125)
    private String side;

    public Trade(String tradeAccount, String type) {
        this.account = tradeAccount;
        this.type = type;
    }

    public Trade(Integer id, String account, String type) {
        this.id = id;
        this.account = account;
        this.type = type;
    }
}
