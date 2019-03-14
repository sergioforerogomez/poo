package com.endava.poo.ui.utils;

import org.apache.log4j.Logger;

public class UriHelper {
    private final static Logger logger = Logger.getLogger(UriHelper.class);

    private final static String THE_MOVIE_DB_BASE_URI = "https://www.themoviedb.org/";

    public static String getMovieDbDiscoverUri() {
        String uri = THE_MOVIE_DB_BASE_URI;
        logger.info("Using movie db base uri: " + uri);
        return uri;
    }
}
