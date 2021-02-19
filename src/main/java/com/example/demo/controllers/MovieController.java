package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

//This is a bean - it is handled by the Spring framework
@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService("src/main/resources/static/film-new.csv");

    @ResponseBody
    @GetMapping("/")
    public String helloWorld() {
        return "Friendly Message";
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getTitle();
    }

    @ResponseBody
    @GetMapping("/getRandomMovie")
    public String getRandomMovie() throws FileNotFoundException {
        return movieService.getRandomMovieOnList();
    }

    @ResponseBody
    @GetMapping("/numberOfMoviesWithAwards")
    public int getNumberOfMoviesWithAwards() throws FileNotFoundException {
        return movieService.numberOfMoviesWithAward();
    }

    @ResponseBody
    @GetMapping("/tenMovies")
    public String getTenRandomMoviesFromList() throws FileNotFoundException {
        return movieService.tenRandomMovies();
    }
}
