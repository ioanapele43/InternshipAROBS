package com.example.musify.service;

import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.dto.SearchDTO;
import com.example.musify.model.Album;
import com.example.musify.model.Band;
import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final ArtistMapper artistMapper;
    private final BandMapper bandMapper;
    private final AlbumMapper albumMapper;

    public SearchService(ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumRepositoryJPA albumRepositoryJPA, ArtistMapper artistMapper, BandMapper bandMapper, AlbumMapper albumMapper) {
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.artistMapper = artistMapper;
        this.bandMapper = bandMapper;
        this.albumMapper = albumMapper;
    }

    @Transactional
    public List<ArtistViewDTO> searchByName(String name) {
        return artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + name + "%").stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
    }

    @Transactional
    public List<BandViewDTO> searchByBandname(String bandname) {
        return bandRepositoryJPA.findBandByBandname("%" + bandname + "%").stream().map(b -> bandMapper.toViewDto(b)).collect(Collectors.toList());
    }

    @Transactional
    public List<AlbumViewDTO> searchByTitle(String title) {
        return albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(title).stream().map(a -> albumMapper.toViewDto(a)).collect(Collectors.toList());
        //return albumRepositoryJPA.findAlbumByTitle("%" + title + "%");
    }

    @Transactional
    public SearchDTO searchAll(String input) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAlbums(albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(input));
        searchDTO.setArtists(artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + input + "%"));
        searchDTO.setBands(bandRepositoryJPA.findBandByBandname("%" + input + "%"));
        return searchDTO;
    }

}
