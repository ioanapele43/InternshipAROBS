package com.example.musify.model;

import javax.persistence.*;

@Entity
@Table(name="song-artist")
public class SongArtist {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("song_id")
    private int songId;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("artist_id")
    private int artistId;
    @Column(name="type")
    private String type;

    public SongArtist() {
    }

    public SongArtist(int songId, int artistId, String type) {
        this.songId = songId;
        this.artistId = artistId;
        this.type = type;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
