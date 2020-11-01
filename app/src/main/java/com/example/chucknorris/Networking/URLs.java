package com.example.chucknorris.Networking;

public class URLs
{
    private static int numberOfJokes;
    private static final String getUrl = "jokes/random";
    private static final String securityBase = "http://";
    private static final String domainBase = "api.icndb.com/";

    public static String getUrl()
    {
        return securityBase + domainBase + getUrl + "/" + numberOfJokes;
    }


    public static void setNumberOfJokes(int numberOfJokes1)
    {
        numberOfJokes = numberOfJokes1;
    }
}