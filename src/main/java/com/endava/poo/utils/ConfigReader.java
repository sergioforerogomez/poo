package com.endava.poo.utils;

import org.apache.log4j.Logger;

public class ConfigReader {
    private final static Logger logger = Logger.getLogger(ConfigReader.class);

    public static String readEnvVar(String envVar) {
        logger.info("Reading environment variable: " + envVar);
        return System.getenv(envVar);
    }
}
