package com.java.spring;

import com.java.spring.domain.Singer;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SingerService {

    private final SingerRepository repository;

    public Singer createSinger(Singer singer) {
        return repository.createSinger(singer);
    }

    public Singer getSingerById(long id) {
        return repository.getSingerById(id);
    }
}
