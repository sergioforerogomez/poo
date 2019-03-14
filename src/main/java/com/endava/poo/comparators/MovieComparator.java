package com.endava.poo.comparators;

import com.endava.poo.api.mapper.MovieMapper;
import com.endava.poo.entities.Movie;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.endava.poo.comparators.functions.MovieFunctions.COMPARE_BY_TITLE;

public class MovieComparator {
    private final static Logger logger = Logger.getLogger(MovieMapper.class);

    private static Map<String, Comparator<Movie>> comparators;

    static {
        comparators = new HashMap<>();
        comparators.put("title", COMPARE_BY_TITLE);
    }

    public static boolean compareMoviesBy(String attribute, List<Movie> movies1, List<Movie> movies2) {
        logger.info("Comparing movies by " + attribute);
        Comparator comparator = comparators.getOrDefault(attribute, COMPARE_BY_TITLE);
        if (movies1.size() != movies2.size()) {
            return false;
        }
        return IntStream.range(0, movies1.size()).parallel()
                .allMatch(i -> comparator.compare(movies1.get(i), movies1.get(i)) == 0);
    }
}
