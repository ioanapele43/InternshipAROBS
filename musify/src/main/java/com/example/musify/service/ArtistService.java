package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ArtistService {
    private final ArtistRepositoryJPA artistRepository;
    private final ArtistMapper artistMapper;

    public ArtistService(ArtistRepositoryJPA artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }


    public List<ArtistViewDTO> getArtists() {
        return artistRepository.findAll().stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
    }

    public ArtistViewDTO getArtistById(int id) {
        return artistMapper.toViewDto(artistRepository.getArtistsById(id));
    }


    @Transactional
    public void saveArtist(ArtistDTO artist) {
        artistRepository.save(artistMapper.toEntity(artist));
    }

    @Transactional
    public void updateArtist(Integer id,ArtistDTO artistDTO) {
        if (artistRepository.getArtistsById(id) == null)
            throw new DataNotFoundException("the data you want to update does not exist");
        Artist artist=artistMapper.toEntity(artistDTO);
        artist.setId(id);
        artistRepository.save(artist);
    }

    @Transactional
    public void deleteArtist(Integer id) {
        if (artistRepository.getArtistsById(id) == null)
            throw new DataNotFoundException("the data you want to delete does not exist");
        artistRepository.delete(artistRepository.getArtistsById(id));
    }


}
