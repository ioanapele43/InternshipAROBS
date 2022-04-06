package com.example.musify.model;

import javax.persistence.*;
@Entity
@Table(name="album-artist")
public class AlbumArtist {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("album_id")
    private int albumId;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("artist_id")
    private int artistId;
    @Column(name="type")
    private String type;

    public AlbumArtist() {
    }

    public AlbumArtist(int albumId, int artistId, String type) {
        this.albumId = albumId;
        this.artistId = artistId;
        this.type = type;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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
