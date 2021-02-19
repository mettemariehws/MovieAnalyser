package com.example.demo.models;

public class Movie {
    private int year;
    private int length;
    private String title;
    private String genre;
    private int popularity;
    private String awards;

    public Movie(int year, int length, String title, String genre, int popularity, String awards){
        this.year = year;
        this.length = length;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.awards = awards;

    }

    public Movie(String[] information){
        this.year = Integer.parseInt(information[0]);
        this.length = Integer.parseInt(information[1]);
        this.title = information[2];
        this.genre = information[3];
        this.popularity = Integer.parseInt(information[4]);
        this.awards = information[5];

    }

    public String getTitle(){
        return this.title;
    }

    public String getAwards(){
        return this.awards;
    }

    public int getPopularity(){
        return this.popularity;
    }

    public int compareTo(Movie m){
        if (this.popularity == m.popularity){
            return 1;
        }else if (this.popularity>m.popularity){
            return 0;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "<br> Movie: " +
                "Title = " + title +
                ", year: " + year +
                ", length: " + length +
                ", genre: " + genre +
                ", popularity: " + popularity +
                ", awards: " + awards;
    }
}
