package com.nnk.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "bid_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidList {


    @Id
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

    @Column(name = "bid_quantity")
    private Double bidQuantity;

    @Column(name = "ask_quantity")
    private Double askQuantity;

    @Column(name = "bid")
    private Double bid;

    @Column(name = "ask")
    private Double ask;

    @Size(max = 125)
    @Column(name = "benchmark", length = 125)
    private String benchmark;

    @Column(name = "bid_list_date")
    private Timestamp bidListDate;

    @Size(max = 125)
    @Column(name = "commentary", length = 125)
    private String commentary;

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

    public BidList(String accountTest, String typeTest, double v) {
        this.account = accountTest;
        this.type = typeTest;
        this.bidQuantity = v;
    }
}
