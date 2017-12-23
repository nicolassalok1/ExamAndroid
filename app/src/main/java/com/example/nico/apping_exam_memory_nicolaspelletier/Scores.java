package com.example.nico.apping_exam_memory_nicolaspelletier;

import java.util.Date;

/**
 * Created by nico on 19/12/2017.
 */

public class Scores {


    private Boolean didWin;
    private String score;
    private String date;
    private String name;

    public Scores(String date, Boolean win, String score, String name)
    {
        this.date = date;
        this.didWin = win;
        this.score = score;
        this.name = name;
    }

    public String getDate() {
        return date;
    }



    public Boolean getDidWin() {
        return didWin;
    }

    public void setDidWin(Boolean didWin) {
        this.didWin = didWin;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public String getName() {
        return name;
    }
}
