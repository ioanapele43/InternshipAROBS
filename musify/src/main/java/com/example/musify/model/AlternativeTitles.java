package com.example.musify.model;

import javax.persistence.*;

@Entity
@Table(name="alternative_titles")
public class AlternativeTitles {
    @Id
    @Column(name="song_id")
    private int song_id;
    @Column(name="alternative_title")
    private String alternativeTitle;

    public AlternativeTitles() {
    }

    public AlternativeTitles(int song_id, String alternativeTitle) {
        this.song_id = song_id;
        this.alternativeTitle = alternativeTitle;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }
}
