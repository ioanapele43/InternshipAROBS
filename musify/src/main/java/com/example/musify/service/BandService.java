package com.example.musify.service;

import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.dto.BandDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.model.Band;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandService {
    private final BandRepositoryJPA bandRepositoryJPA;
    private final BandMapper bandMapper;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final ArtistMapper artistMapper;
    public BandService(BandRepositoryJPA bandRepositoryJPA, BandMapper bandMapper, ArtistRepositoryJPA artistRepositoryJPA, ArtistMapper artistMapper) {
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.bandMapper = bandMapper;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.artistMapper = artistMapper;
    }

    public List<BandViewDTO> getAllBands() {
        return bandRepositoryJPA.findAll().stream().map(b -> bandMapper.toViewDto(b)).collect(Collectors.toList());
    }

    public BandViewDTO getBandById(Integer id) {
        return bandMapper.toViewDto(bandRepositoryJPA.getBandById(id));
    }

    @Transactional
    public void createBand(BandDTO bandDTO) {
        bandRepositoryJPA.save(bandMapper.toEntity(bandDTO));
    }

    @Transactional
    public void updateBand(BandDTO bandDTO) {
        bandRepositoryJPA.save(bandMapper.toEntity(bandDTO));
    }

    @Transactional
    public void deleteBand(BandDTO bandDTO) {
        bandRepositoryJPA.delete(bandMapper.toEntity(bandDTO));
    }
    @Transactional
    public void addBandMember(Integer idBand,Integer idArtist){
        Band band=bandRepositoryJPA.getBandById(idBand);
        band.addMember(artistRepositoryJPA.getArtistsById(idArtist));
    }
    @Transactional
    public List<ArtistViewDTO> getBandMembers(Integer id){
        return bandRepositoryJPA.getBandById(id).getMembers().stream().map(member->artistMapper.toViewDto(member)).collect(Collectors.toList());
    }

}
