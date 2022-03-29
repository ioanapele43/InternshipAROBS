package com.example.musify.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Song {
    private int id;
    private String title;
    private String alternativeTitle;
    private List<Artist> contributorArtist;
    private Album album;
    private Time duration;
    private Date creationDate;

    public Song(String title, String alternativeTitle, List<Artist> contributorArtist, Album album, Time duration, Date creationDate) {
        this.title = title;
        this.alternativeTitle = alternativeTitle;
        this.contributorArtist = contributorArtist;
        this.album = album;
        this.duration = duration;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }

    public List<Artist> getContributorArtist() {
        return contributorArtist;
    }

    public void setContributorArtist(List<Artist> contributorArtist) {
        this.contributorArtist = contributorArtist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
