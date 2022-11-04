package com.api.controller;

import com.api.domain.RaitingsEntity;
import com.api.dto.RaitingDto;
import com.api.dto.assembler.RaitingAssembler;
import com.api.service.RaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/raitings")
public class RaitingController {
    @Autowired
    private RaitingService raitingService;
    @Autowired
    private RaitingAssembler raitingAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RaitingDto> getById(@PathVariable Integer id) {
        RaitingsEntity entity = raitingService.findById(id);
        RaitingDto ratingDto = raitingAssembler.toModel(entity);
        return new ResponseEntity<>(ratingDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RaitingDto>> getAllBudgets() {
        List<RaitingsEntity> entities = raitingService.findAll();
        CollectionModel<RaitingDto> entDtos = raitingAssembler.toCollectionModel(entities);
        return new ResponseEntity<>(entDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RaitingDto> add(@RequestBody RaitingsEntity entity) {
        RaitingsEntity raiting = raitingService.create(entity);
        RaitingDto entityDto = raitingAssembler.toModel(raiting);
        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody RaitingsEntity updateNom, @PathVariable Integer id) {
        raitingService.update(id, updateNom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        raitingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}