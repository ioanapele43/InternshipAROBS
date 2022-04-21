package com.example.musify.service.mappers;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.model.Playlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    PlaylistDTO toDto(Playlist playlist);

    Playlist toEntity(PlaylistDTO playlistDTO);

}
