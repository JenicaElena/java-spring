package com.java.spring;

import com.java.spring.domain.Singer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Comparator;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SingerRepository {

    public static final String SELECT = "select * from singer where id = ? ";

    public static final String INSERT =
            "INSERT INTO singer (firstName, lastName, birthDate) " +
                    "VALUES (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public Singer createSinger(Singer singer) {
        int updatedRows = jdbcTemplate.update(INSERT, singer.getFirstName(), singer.getLastName(), singer.getBirthDate());

        if (updatedRows == 1) {
            return jdbcTemplate.queryForStream("select * from singer", rowMapper())
                               .sorted(Comparator.comparing(Singer::getId).reversed())
                               .findFirst()
                               .get();
        }
        throw new IllegalStateException("Singer not created");

    }

    public Singer getSingerById(long id) {
        return jdbcTemplate.queryForObject(SELECT, rowMapper(), id);
    }

    //Singer mapRow(ResultSet rs, int rowNum)
    private RowMapper<Singer> rowMapper() {
        return (ResultSet rs, int rowNum) -> Singer.builder()
                                                   .id(rs.getLong("id"))
                                                   .firstName(rs.getString("firstName"))
                                                   .lastName(rs.getString("lastName"))
                                                   .birthDate(rs.getDate("birthDate").toLocalDate())
                                                   .build();
    }
}
