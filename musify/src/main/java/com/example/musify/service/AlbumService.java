package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.model.Album;
import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.service.mappers.AlbumMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final AlbumMapper albumMapper;

    public AlbumService(AlbumRepositoryJPA albumRepositoryJPA, AlbumMapper albumMapper) {
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.albumMapper = albumMapper;
    }

    public List<Album> getAllAlbums() {
        return albumRepositoryJPA.findAll();
    }

    public Album getAlbumById(Integer id) {
        return albumRepositoryJPA.getAlbumById(id);
    }

    @Transactional
    public void createAlbum(AlbumDTO albumDTO) {
        albumRepositoryJPA.save(albumMapper.toEntity(albumDTO));
    }

    @Transactional
    public void updateAlbum(AlbumDTO albumDTO) {
        albumRepositoryJPA.save(albumMapper.toEntity(albumDTO));
    }

    @Transactional
    public void deleteAlbum(AlbumDTO albumDTO) {
        albumRepositoryJPA.delete(albumMapper.toEntity(albumDTO));
    }

}
