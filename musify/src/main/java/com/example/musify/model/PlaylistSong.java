package com.example.musify.model;

import javax.persistence.*;
@Entity
@Table(name="playlist-songs")
public class PlaylistSong {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playlist_id")
    private int playlistId;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("song_id")
    private int songId;
    @Column(name="song_order_number")
    private int songOrderNumber;

    public PlaylistSong() {
    }

    public PlaylistSong(int palylistId, int songId, int songOrderNumber) {
        this.playlistId = palylistId;
        this.songId = songId;
        this.songOrderNumber = songOrderNumber;
    }

    public int getPalylistId() {
        return playlistId;
    }

    public void setPalylistId(int palylistId) {
        this.playlistId = palylistId;
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
