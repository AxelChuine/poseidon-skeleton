package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rule_name")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleName {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 125)
    @Column(name = "name", length = 125)
    private String name;

    @Size(max = 125)
    @Column(name = "description", length = 125)
    private String description;

    @Size(max = 125)
    @Column(name = "json", length = 125)
    private String json;

    @Size(max = 512)
    @Column(name = "template", length = 512)
    private String template;

    @Size(max = 125)
    @Column(name = "sql_str", length = 125)
    private String sqlStr;

    @Size(max = 125)
    @Column(name = "sql_part", length = 125)
    private String sqlPart;

    public RuleName(String ruleName, String description, String json, String template, String sql, String sqlPart) {
        this.name = ruleName;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sql;
        this.sqlPart = sqlPart;
    }
}
