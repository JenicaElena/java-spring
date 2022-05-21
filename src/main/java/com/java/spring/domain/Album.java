package com.java.spring.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    private long id;

    private LocalDate releaseDate;

    private String name;

    private String description;
}