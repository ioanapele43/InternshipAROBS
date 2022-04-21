package com.example.musify.service.mappers;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.model.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumDTO toDto(Album album);

    Album toEntity(AlbumDTO albumDTO);
}
