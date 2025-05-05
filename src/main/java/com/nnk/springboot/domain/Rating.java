package com.nnk.springboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "moodysRating", length = 125)
    private String moodysRating;

    @Column(name = "sandPRating", length = 125)
    private String sandPRating;

    @Column(name = "fitchRating", length = 125)
    private String fitchRating;

    @Column(name = "orderNumber")
    private Integer orderNumber;
}
