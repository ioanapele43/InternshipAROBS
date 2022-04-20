package com.example.musify.dto;

import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchDTO {
    private List<Artist> artists;
    private List<Band> bands;
    private List<Album> albums;

}
