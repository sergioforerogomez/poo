package com.endava.steps;

import com.endava.poo.api.mapper.MovieMapper;
import com.endava.poo.api.services.HttpRequest;
import com.endava.poo.api.services.ParamsBuilder;
import com.endava.poo.api.services.UriHelper;
import com.endava.poo.comparators.MovieComparator;
import com.endava.poo.entities.Movie;
import com.endava.poo.utils.SessionHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.endava.poo.utils.SessionHelper.Session.MOVIE_LIST_API;
import static com.endava.poo.utils.SessionHelper.Session.MOVIE_LIST_UI;
import static org.junit.Assert.assertTrue;

public class MoviesSteps {
    @Given("^I request movies from page number \"([^\"]*)\"$")
    public void iRequestMoviesFromPageNumber(String page) {
        String uri = UriHelper.getMovieDbDiscoverUri();
        Map<String, ?> params = new ParamsBuilder().baseParams().build();
        String json = HttpRequest.getJsonStringFromUri(uri, params);
        List<Movie> movies = MovieMapper.mapJsonToMoviesList(json);

        SessionHelper.put(MOVIE_LIST_API, movies);
    }

    @When("^I see the movies from page number \"([^\"]*)\"$")
    public void iSeeTheMoviesFromPageNumber(String page) {
        List<Movie> movies = null;

        SessionHelper.put(MOVIE_LIST_UI, movies);
    }

    @Then("^the movies \"([^\"]*)\" match$")
    public void theMoviesMatch(String attribute) {
        boolean areSameMovies;
        List<Movie> apiMovies = SessionHelper.getAsList(MOVIE_LIST_API, Movie.class);
        List<Movie> uiMovies = SessionHelper.getAsList(MOVIE_LIST_API, Movie.class);

        areSameMovies = MovieComparator.compareMoviesBy(attribute, apiMovies, uiMovies);
        assertTrue("Expected: movies to be the same", areSameMovies);
    }
}
