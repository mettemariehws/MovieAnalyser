package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieAnalysisService {

    private File fileOfMovies;
    private String filePath;
    private Scanner sc;

    public MovieAnalysisService(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Movie> getTheFullMovieList() throws FileNotFoundException {

        ArrayList<Movie> theListWithTheMovie = new ArrayList();

        try {
            this.fileOfMovies = new File(this.filePath);
            this.sc = new Scanner(fileOfMovies);
        } catch (FileNotFoundException fejl) {
            System.out.println("Fejl i movie list constructor");
        }

        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {

            String[] lineFromFile = sc.nextLine().split(";");
            String[] informationOnMovies = new String[6];


            informationOnMovies[0] = lineFromFile[0]; //year
            informationOnMovies[1] = lineFromFile[1]; //length
            informationOnMovies[2] = lineFromFile[2]; //Title
            informationOnMovies[3] = lineFromFile[3]; //genre
            informationOnMovies[4] = lineFromFile[4]; //popularity
            informationOnMovies[5] = lineFromFile[5]; //awards

            Movie movieList = new Movie(informationOnMovies);
            theListWithTheMovie.add(movieList);

        }
        return theListWithTheMovie;
    }

    public Movie getFirstMovieOfList() throws FileNotFoundException {
        //Instantiated a file from film-new.csv
        File movieList = new File(this.filePath);
        //Scanner
        Scanner sc = new Scanner(movieList);
        //Skip 2 lines
        sc.nextLine();
        sc.nextLine();
        //Split
        String[] firstMovieAsArray = sc.nextLine().split(";");
        //Created a model from data
        Movie firstMovie = new Movie(
                Integer.parseInt(firstMovieAsArray[0]), Integer.parseInt(firstMovieAsArray[1]), firstMovieAsArray[2], firstMovieAsArray[3], Integer.parseInt(firstMovieAsArray[4]), firstMovieAsArray[5]);
        return firstMovie;
    }

    public String getRandomMovieOnList() throws FileNotFoundException {

        Random random = new Random();
        int randomIndex = random.nextInt(getTheFullMovieList().size());

        String titleOnRandomMovie = getTheFullMovieList().get(randomIndex).getTitle();

        return titleOnRandomMovie;

    }

    public int numberOfMoviesWithAward() throws FileNotFoundException {

        int yesToAward = 0;

        for (int i = 0; i < getTheFullMovieList().size(); i++) {
            if (getTheFullMovieList().get(i).getAwards().equalsIgnoreCase("yes")) {
                yesToAward++;
            }
        }
        return yesToAward;
    }

    public String tenRandomMovies() throws FileNotFoundException {

        ArrayList<Movie> tenRandomMovies = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int justARandomMovie = random.nextInt(getTheFullMovieList().size());
            Movie oneOfTenRandomMovies = getTheFullMovieList().get(justARandomMovie);
            tenRandomMovies.add(oneOfTenRandomMovies);
            for(int j = 0; j < 10; j++){
                Collections.sort(tenRandomMovies,Movie::compareTo);
            }
            Collections.reverse(tenRandomMovies);
        }
        return tenRandomMovies.toString();
    }
}
