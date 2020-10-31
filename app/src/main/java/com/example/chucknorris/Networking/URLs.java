package com.example.chucknorris.Networking;

public class URLs
{
    private static final String getUrl = "jokes/random/10";
    private static final String securityBase = "http://";
    private static final String domainBase = "api.icndb.com/";
    public static String getUrl()
    {
        return securityBase + domainBase + getUrl;
    };
}