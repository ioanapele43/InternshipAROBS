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
    private List<ArtistViewDTO> artists;
    private List<BandViewDTO> bands;
    private List<AlbumViewDTO> albums;

}
