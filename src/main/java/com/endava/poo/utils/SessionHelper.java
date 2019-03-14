package com.endava.poo.utils;

import net.serenitybdd.core.Serenity;
import org.apache.log4j.Logger;

import java.util.List;

import static com.endava.poo.utils.Constants.OBJECT_MAPPING_ERROR;

public class SessionHelper {
    private final static Logger logger = Logger.getLogger(SessionHelper.class);

    public static void put(Session key, Object value) {
        Serenity.getCurrentSession().put(key, value);
    }

    public static <T> List<T> getAsList(Session key, Class<T> genericClass) {
        Object object = Serenity.getCurrentSession().get(key);
        try {
            return (List<T>) object;
        } catch (ClassCastException exception) {
            logger.error(OBJECT_MAPPING_ERROR + exception.getMessage());
            return null;
        }
    }

    public enum Session {
        MOVIE_LIST_API("MOVIE_LIST_API"), MOVIE_LIST_UI("MOVIE_LIST_UI");

        String name;

        Session(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
