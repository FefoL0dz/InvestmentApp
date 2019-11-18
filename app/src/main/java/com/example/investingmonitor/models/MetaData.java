package com.example.investingmonitor.models;

public class MetaData
{
    private String OutputSize;

    private String Symbol;

    private String Interval;

    private String Information;

    private String LastRefreshed;

    private String TimeZone;

    public String getOutputSize() {
        return OutputSize;
    }

    public void setOutputSize(String outputSize) {
        OutputSize = outputSize;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getInterval() {
        return Interval;
    }

    public void setInterval(String interval) {
        Interval = interval;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public String getLastRefreshed() {
        return LastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        LastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [5. Output Size = "+OutputSize+", 2. Symbol = "+Symbol+", 4. Interval = "+Interval+", 1. Information = "+Information+", 3. Last Refreshed = "+LastRefreshed+", 6. Time Zone = "+TimeZone+"]";
    }
}