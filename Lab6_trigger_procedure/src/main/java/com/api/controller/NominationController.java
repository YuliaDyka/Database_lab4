package com.api.controller;

import com.api.domain.NominationsEntity;
import com.api.dto.NominationDto;
import com.api.dto.assembler.NominationAssembler;
import com.api.service.NominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/nominations")
public class NominationController {
    @Autowired
    private NominationService nominationService;
    @Autowired
    private NominationAssembler nominationAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NominationDto> getById(@PathVariable Integer id) {
        NominationsEntity nom = nominationService.findById(id);
        NominationDto nomDto = nominationAssembler.toModel(nom);
        return new ResponseEntity<>(nomDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<NominationDto>> getAllBudgets() {
        List<NominationsEntity> nom = nominationService.findAll();
        CollectionModel<NominationDto> nomDtos = nominationAssembler.toCollectionModel(nom);
        return new ResponseEntity<>(nomDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<NominationDto> add(@RequestBody NominationsEntity budget) {
        NominationsEntity newNom = nominationService.create(budget);
        NominationDto nomDto = nominationAssembler.toModel(newNom);
        return new ResponseEntity<>(nomDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody NominationsEntity updateNom, @PathVariable Integer id) {
        nominationService.update(id, updateNom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        nominationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}