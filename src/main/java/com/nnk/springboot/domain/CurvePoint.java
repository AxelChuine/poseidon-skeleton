package com.nnk.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "curve_point")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurvePoint {


    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "CurveId")
    private Integer curveId;

    @Column(name = "asOfDate")
    private Timestamp asOfDate;

    @Column(name = "term")
    private Double term;

    @Column(name = "value")
    private Double value;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    public CurvePoint(Integer id, double term, double value) {
        this.id = id;
        this.term = term;
        this.value = value;
    }

}
