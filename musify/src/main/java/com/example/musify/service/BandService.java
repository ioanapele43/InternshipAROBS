package com.example.musify.service;

import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.BandDTO;
import com.example.musify.model.Band;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.mappers.BandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private BandRepositoryJPA bandRepositoryJPA;
    @Autowired
    private BandMapper bandMapper;
    public List<Band> getAllBands(){
        return bandRepositoryJPA.findAll();
    }
    public Optional<Band> getBandById(Integer id){
        return bandRepositoryJPA.findById(id);
    }
    @Transactional
    public void createBand(BandDTO bandDTO){
        bandRepositoryJPA.save(bandMapper.toEntity(bandDTO));
    }
    @Transactional
    public void updateBand(BandDTO bandDTO){
        bandRepositoryJPA.save(bandMapper.toEntity(bandDTO));
    }
    @Transactional
    public void deleteBand(BandDTO bandDTO){
        bandRepositoryJPA.delete(bandMapper.toEntity(bandDTO));
    }

}
