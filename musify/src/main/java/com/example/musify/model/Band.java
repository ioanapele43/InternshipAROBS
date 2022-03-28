package com.example.musify.model;

import java.sql.Date;

public class Band extends Artist {
    private String bandname;
    private String location;

    public Band(String bandname, String location, Date startDate, Date endDate) {
        this.bandname = bandname;
        this.location = location;
        super.setStartDate(startDate);
        super.setEndDate(endDate);
    }

    public String getBandname() {
        return bandname;
    }

    public void setBandname(String bandname) {
        this.bandname = bandname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
