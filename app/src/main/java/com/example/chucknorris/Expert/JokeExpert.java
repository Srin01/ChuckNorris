package com.example.chucknorris.Expert;

import java.util.ArrayList;

public class JokeExpert
{
    private ArrayList<String> jokes = new ArrayList<>();
    public void addJoke(String joke)
    {
        jokes.add(joke);
    }
    public String getJoke(int index)
    {
        return jokes.get(index);
    }
}
