package com.example.musify.repo;

import com.example.musify.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SongRepositoty {
    private JdbcTemplate jdbcTemplate;
    public SongRepositoty(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
   
}
