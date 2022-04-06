package com.example.musify.model;

import javax.persistence.*;

@Entity
@Table(name="album-songs")
public class AlbumSong {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("album_id")
    private int albumId;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("song_id")
    private int songId;
    @Column(name="song_order_number")
    private int songOrderNumber;

    public AlbumSong() {
    }

    public AlbumSong(int albumId, int songId, int songOrderNumber) {
        this.albumId = albumId;
        this.songId = songId;
        this.songOrderNumber = songOrderNumber;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getSongOrderNumber() {
        return songOrderNumber;
    }

    public void setSongOrderNumber(int songOrderNumber) {
        this.songOrderNumber = songOrderNumber;
    }
}
