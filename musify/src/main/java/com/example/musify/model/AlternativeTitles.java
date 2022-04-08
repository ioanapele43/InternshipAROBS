package com.example.musify.model;

import javax.persistence.*;

@Entity
@Table(name="alternative_titles")
public class AlternativeTitles {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="alternative_title")
    private String alternativeTitle;

    public AlternativeTitles() {
    }

    public AlternativeTitles(Integer id, String alternativeTitle) {
        this.id = id;
        this.alternativeTitle = alternativeTitle;
    }

    public Integer getSong_id() {
        return id;
    }

    public void setSong_id(int song_id) {
        this.id = song_id;
    }

    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }
}
