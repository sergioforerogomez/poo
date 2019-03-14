package com.endava.poo.api.services;

import org.apache.log4j.Logger;

public class UriHelper {
    private final static Logger logger = Logger.getLogger(UriHelper.class);

    private final static String THE_MOVIE_DB_BASE_URI = "https://api.themoviedb.org/3";
    private final static String THE_MOVIE_DB_DISCOVER_URI = "/discover/movie";

    public static String getMovieDbDiscoverUri() {
        String uri = THE_MOVIE_DB_BASE_URI + THE_MOVIE_DB_DISCOVER_URI;
        logger.info("Using movie db discover uri: " + uri);
        return uri;
    }
}
