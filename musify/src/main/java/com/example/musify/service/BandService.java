package com.example.musify.service;

import com.example.musify.dto.BandDTO;
import com.example.musify.model.Band;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.BandMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BandService {
    private final BandRepositoryJPA bandRepositoryJPA;
    private final BandMapper bandMapper;

    public BandService( BandRepositoryJPA bandRepositoryJPA, BandMapper bandMapper) {
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.bandMapper = bandMapper;
    }

    public List<Band> getAllBands() {
        return bandRepositoryJPA.findAll();
    }

    public Band getBandById(Integer id) {
        return bandRepositoryJPA.getBandById(id);
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

}
