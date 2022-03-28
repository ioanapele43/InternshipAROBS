package com.example.musify.repo;

import com.example.musify.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    public UserRepository(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);

    }
    public void getALlUSers(){
        List<User> users=new ArrayList<User>();
        jdbcTemplate.query("Select * from users;", (RowCallbackHandler) users);

    }
}
