package com.endava.poo.api.services;

import com.endava.poo.utils.ConfigReader;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ParamsBuilder {
    private final static Logger logger = Logger.getLogger(ParamsBuilder.class);

    private final static String THE_MOVIE_DB_API_KEY = "api_key";
    private final static String THE_MOVIE_DB_API_TOKEN = "THE_MOVIE_DB_API_TOKEN";

    private static Map<String, String> params;

    public ParamsBuilder baseParams() {
        params = new HashMap<>();
        String theMovieDbApiToken = ConfigReader.readEnvVar(THE_MOVIE_DB_API_TOKEN);
        params.put(THE_MOVIE_DB_API_KEY, theMovieDbApiToken);
        return this;
    }

    public Map<String, ?> build() {
        logger.info("Constructing " + params.size() + " parameters");
        return params;
    }
}
