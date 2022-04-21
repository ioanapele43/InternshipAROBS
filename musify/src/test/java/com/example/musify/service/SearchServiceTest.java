package com.example.musify.service;

import com.example.musify.model.Band;
import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.repo.BandRepositoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {
    @Mock
     ArtistRepositoryJPA artistRepositoryJPA;
    @Mock
    BandRepositoryJPA bandRepositoryJPA;
    @Mock
    AlbumRepositoryJPA albumRepositoryJPA;
    SearchService searchService;

    @BeforeEach
    public void init(){
        searchService=new SearchService(artistRepositoryJPA,bandRepositoryJPA,albumRepositoryJPA);
    }
    @Test
    @DisplayName("Album-NULL")
    public void givenNotExistingAlbum_whenSearchAlbum_thenReturnNull(){
        when(searchService.searchByTitle(any())).thenReturn(null);
        assertEquals(searchService.searchByTitle("bt"),null);
    }
    @Test
    @DisplayName("Search for an existing band")
    public void givenExistingBand_whenSearchBand_thenReturnBand(){
        Band band=new Band();
        band.setBandname("aksa");
        List<Band> bandList=new ArrayList<Band>();
        bandList.add(band);
        when(searchService.searchByBandname(any())).thenReturn(bandList);
        assertEquals(searchService.searchByBandname("aksa"),bandList);

    }

}