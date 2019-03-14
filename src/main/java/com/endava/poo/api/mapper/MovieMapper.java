package com.endava.poo.api.mapper;

import com.endava.poo.entities.Movie;
import com.endava.poo.entities.PageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

import static com.endava.poo.utils.Constants.MOVIE_MAPPING_ERROR;

public class MovieMapper {
    private final static Logger logger = Logger.getLogger(MovieMapper.class);

    public static List<Movie> mapJsonToMoviesList(String json) {
        logger.info("Mapping json to movies as list");
        List<Movie> movies = null;
        try {
            PageResult pageResult = new ObjectMapper().readValue(json, PageResult.class);
            movies = pageResult.getMovies();
        } catch (IOException exception) {
            logger.error(MOVIE_MAPPING_ERROR + exception.getMessage());
        }
        logger.info(movies.size() + " movies has been mapped");
        return movies;
    }
}
