package com.example.musify.service;

import com.example.musify.dto.*;
import com.example.musify.repo.*;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.ArtistMapper;
import com.example.musify.service.mappers.BandMapper;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final SongMapper songMapper;
    private final ArtistMapper artistMapper;
    private final BandMapper bandMapper;
    private final AlbumMapper albumMapper;
    private final ValidationsService validationsService;
    private final AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;

    public SearchService(ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumRepositoryJPA albumRepositoryJPA, SongRepositoryJPA songRepositoryJPA, SongMapper songMapper, ArtistMapper artistMapper, BandMapper bandMapper, AlbumMapper albumMapper, ValidationsService validationsService, AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA) {
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.songMapper = songMapper;
        this.artistMapper = artistMapper;
        this.bandMapper = bandMapper;
        this.albumMapper = albumMapper;
        this.validationsService = validationsService;
        this.alternativeTitlesRepositoryJPA = alternativeTitlesRepositoryJPA;
    }

    @Transactional
    public List<ArtistViewDTO> searchByName(String name) {
       // return artistRepositoryJPA.findArtistByFirstnameOrLastname("%" + name + "%").stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
        return artistRepositoryJPA.getArtistsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(name,name).stream().map(a -> artistMapper.toViewDto(a)).collect(Collectors.toList());
    }

    @Transactional
    public List<BandViewDTO> searchByBandname(String bandname) {
        return bandRepositoryJPA.getBandByBandnameContainingIgnoreCase(bandname).stream().map(b -> bandMapper.toViewDto(b)).collect(Collectors.toList());
    }

    @Transactional
    public List<AlbumViewDTO> searchByTitle(String title) {
        return albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(title).stream().map(a -> albumMapper.toViewDto(a)).collect(Collectors.toList());
        //return albumRepositoryJPA.findAlbumByTitle("%" + title + "%");
    }
    @Transactional
    public List<SongViewDTO> searchSongByTitle(String title){
        return songRepositoryJPA.getSongByTitleContainingIgnoreCase(title).stream().map(s->songMapper.toViewDto(s)).collect(Collectors.toList());
    }
    @Transactional
    public Set<SongViewDTO> searchSongsByAlternativeTitle(String alternativeTitle){
        return alternativeTitlesRepositoryJPA.getAlternativeTitlesByAlternativeTitleContainingIgnoreCase(alternativeTitle).stream().map(at->songMapper.toViewDto(at.getSong())).collect(Collectors.toSet());
    }

    @Transactional
    public SearchDTO searchAll(String input) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setAlbums(albumRepositoryJPA.findAlbumByTitleContainingIgnoreCase(input).stream().map(a->albumMapper.toViewDto(a)).collect(Collectors.toList()));
        searchDTO.setArtists(artistRepositoryJPA.getArtistsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(input,input).stream().map(a->artistMapper.toViewDto(a)).collect(Collectors.toList()));
        searchDTO.setBands(bandRepositoryJPA.getBandByBandnameContainingIgnoreCase(input).stream().map(b->bandMapper.toViewDto(b)).collect(Collectors.toList()));
        searchDTO.setSongs(songRepositoryJPA.getSongByTitleContainingIgnoreCase(input).stream().map(s->songMapper.toViewDto(s)).collect(Collectors.toList()));
        searchDTO.setSongsByAlternativeTitle(alternativeTitlesRepositoryJPA.getAlternativeTitlesByAlternativeTitleContainingIgnoreCase(input).stream().map(at->songMapper.toViewDto(at.getSong())).collect(Collectors.toSet()));
        // pentru a separa listele de piese gasite in urma cautarii in functie de titlu si cele gasite in functie de titlul alternativ le-am pus in liste diferite
        // in lista gasita cu alternative title o sa am dublicate, sa le elimin sau sa las asa lista?
        // sau as putea schimba ultima lista intr-o lista de alternative titles si atunci va returna doar structura aceea si o sa am si un id de la piesa?
        return searchDTO;
    }

}
