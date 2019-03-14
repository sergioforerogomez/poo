package com.endava.poo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Movie {
    @JsonProperty("vote_count")
    private int voteCount;
    private int id;
    private boolean video;
    @JsonProperty("vote_average")
    private double voteAverage;
    private String title;
    private double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private boolean adult;
    private String overview;
    @JsonProperty("release_date")
    private String realeaseDate;
}
