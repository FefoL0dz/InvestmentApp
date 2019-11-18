package com.example.investingmonitor.models;

public class Stock {

    private String[] date;

    private String[] volume;

    private String[] high;

    private String[] low;

    private MetaData MetaData;

    private String[] close;

    private String[] open;

    public String[] getDate ()
    {
        return date;
    }

    public void setDate (String[] date)
    {
        this.date = date;
    }

    public String[] getVolume ()
    {
        return volume;
    }

    public void setVolume (String[] volume)
    {
        this.volume = volume;
    }

    public String[] getHigh ()
    {
        return high;
    }

    public void setHigh (String[] high)
    {
        this.high = high;
    }

    public String[] getLow ()
    {
        return low;
    }

    public void setLow (String[] low)
    {
        this.low = low;
    }

    public MetaData getMetaData ()
    {
        return MetaData;
    }

    public void setMetaData (MetaData MetaData)
    {
        this.MetaData = MetaData;
    }

    public String[] getClose ()
    {
        return close;
    }

    public void setClose (String[] close)
    {
        this.close = close;
    }

    public String[] getOpen ()
    {
        return open;
    }

    public void setOpen (String[] open)
    {
        this.open = open;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", volume = "+volume+", high = "+high+", low = "+low+", Meta Data = "+MetaData+", close = "+close+", open = "+open+"]";
    }
}