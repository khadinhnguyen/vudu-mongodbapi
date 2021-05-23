package com.nguyendkha.vudumongodbapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String synopsis;
    private Double rentalPrice;
    private Double purchasePrice;
    private String category;
    private String genre;
    private Integer rating;
    private Integer numberOfStar;
    private String feature;
    private String largePosterImg;
    private String smallPosterImg;
    private Date dateCreated;



}
