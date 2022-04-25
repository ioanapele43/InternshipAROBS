package com.example.musify.service;

import com.example.musify.dto.SearchDTO;
import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumRepositoryJPA albumRepositoryJPA;

    public SearchService(ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumRepositoryJPA albumRepositoryJPA) {
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumRepositoryJPA = albumRepositoryJPA;
    }

    @Transactional
    public List<Artist> searchByName(String name) {
        return artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + name + "%");
    }

    @Transactional
    public List<Band> searchByBandname(String bandname) {
        return bandRepositoryJPA.findBandByBandname("%" + bandname + "%");
    }

    @Transactional
    public List<Album> searchByTitle(String title) {
        return albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(title);
        //return albumRepositoryJPA.findAlbumByTitle("%" + title + "%");
    }

    @Transactional
    public SearchDTO searchAll(String input) {
        SearchDTO searchDTO = new SearchDTO();
        //searchDTO.setAlbums(albumRepositoryJPA.findAlbumByTitle("%" + input + "%"));
        searchDTO.setArtists(artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + input + "%"));
        searchDTO.setBands(bandRepositoryJPA.findBandByBandname("%" + input + "%"));
        return searchDTO;
    }

}
