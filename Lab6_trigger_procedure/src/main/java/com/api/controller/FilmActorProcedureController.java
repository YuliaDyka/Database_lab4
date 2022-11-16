package com.api.controller;

import com.api.domain.FilmactorsEntity;
import com.api.dto.FilmActorDto;
import com.api.dto.assembler.FilmActorAssembler;
import com.api.service.FilmActorProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/filmactor_procedure")
public class FilmActorProcedureController {

    @Autowired
    FilmActorProcedureService filmActorProcedureService;
    @Autowired
    FilmActorAssembler filmActorAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmActorDto> getById(@PathVariable Integer id) {
        FilmactorsEntity entity = filmActorProcedureService.findById(id);
        FilmActorDto faDto = filmActorAssembler.toModel(entity);

        return new ResponseEntity<>(faDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<FilmActorDto> addFilmActor(@RequestBody FilmactorsEntity entity) {

        FilmactorsEntity newEntity = filmActorProcedureService
                .addFilmActor(entity.getFilmId(), entity.getActorId());

        FilmActorDto filmActorDtoDto = filmActorAssembler.toModel(newEntity);

        return new ResponseEntity<>(filmActorDtoDto, HttpStatus.CREATED);
    }
}
