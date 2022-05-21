package com.java.spring;

import com.java.spring.domain.Singer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/singers")
@AllArgsConstructor
public class SingerController { //http://localhost:8090/singers/5

    private final SingerService service; //DI dependency injection --> to be read

    @GetMapping("/{id}")
    public Singer getSingerById(@PathVariable long id) {
        return service.getSingerById(id);
    }

    @PostMapping
    public Singer createSinger(@RequestBody @Valid Singer singer) {
        return service.createSinger(singer);
    }


}
