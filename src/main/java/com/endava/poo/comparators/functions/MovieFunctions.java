package com.endava.poo.comparators.functions;

import com.endava.poo.entities.Movie;

import java.util.Comparator;

public class MovieFunctions {
    public final static Comparator<Movie> COMPARE_BY_TITLE = Comparator.comparing(Movie::getTitle);
}
