package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ArtistService {
    private final ArtistRepositoryJPA artistRepository;
    private final ArtistMapper artistMapper;
    private final ValidationsService validationsService;

    public ArtistService(ArtistRepositoryJPA artistRepository, ArtistMapper artistMapper, ValidationsService validationsService) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
        this.validationsService = validationsService;
    }


    public List<ArtistViewDTO> getArtists() {
        return artistRepository.findAll().stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
    }

    public ArtistViewDTO getArtistById(int id) {
        validationsService.checkIfAnArtistExists(id);
        return artistMapper.toViewDto(artistRepository.getArtistsById(id));
    }


    @Transactional
    public void saveArtist(ArtistDTO artist) {
        artistRepository.save(artistMapper.toEntity(artist));
    }

    @Transactional
    public void updateArtist(Integer id,ArtistDTO artistDTO) {
        validationsService.checkIfAnArtistExists(id);
        Artist artist=artistMapper.toEntity(artistDTO);
        artist.setId(id);
        artistRepository.save(artist);
    }

    @Transactional
    public void deleteArtist(Integer id) {
        validationsService.checkIfAnArtistExists(id);
        artistRepository.delete(artistRepository.getArtistsById(id));
    }


}
