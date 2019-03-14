package com.endava.poo.api.services;


import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpRequest {
    private final static Logger logger = Logger.getLogger(HttpRequest.class);

    private static final ContentType CONTENT_TYPE = ContentType.JSON;

    public static String getJsonStringFromUri(String uri, Map<String, ?> params) {
        logger.info("GET to uri " + uri + " and " + params.size() + " parameters");
        return given().contentType(CONTENT_TYPE)
                .params(params)
                .when()
                .get(uri)
                .then()
                .extract()
                .response()
                .getBody()
                .asString();
    }
}
