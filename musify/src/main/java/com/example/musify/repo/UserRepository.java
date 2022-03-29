package com.example.musify.repo;

import com.example.musify.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    public UserRepository(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);

    }
    public List<User> getALlUSers(){

       return jdbcTemplate.query("Select * from users ;",
                (rs, rowNum) ->
                        new User(
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }
    public List<User> getUserById(int id){
        return jdbcTemplate.query("Select * from users where idusers=?;",new Object[]{id},
                (rs, rowNum) ->
                        new User(
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }
    public void insertUser(User user){
        jdbcTemplate.update("insert into users(firstname,lastname, email, password,country,role) values (?,?,?,?,?,?);",user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getCountry(),user.getRole());
    }
    public void updateUser(User user){
        jdbcTemplate.update("update users set firstname=?, lastname=?,password=?,country=?,role=? where email=?;",user.getFirstName(),user.getLastName(),user.getPassword(),user.getCountry(),user.getRole(),user.getEmail());
    }
    public void deleteUser(User user){
        jdbcTemplate.update("delete from users where email=?;",user.getEmail());
    }
}
