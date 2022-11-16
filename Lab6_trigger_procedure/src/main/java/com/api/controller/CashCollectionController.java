package com.api.controller;

import com.api.domain.CashCollectionEntity;
import com.api.dto.CashCollectionDto;
import com.api.dto.assembler.CashCollectionAssembler;
import com.api.service.CashCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cashCollections")
public class CashCollectionController {
    @Autowired
    private CashCollectionService cashCollectionService;
    @Autowired
    private CashCollectionAssembler cashCollectionAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CashCollectionDto> getById(@PathVariable Integer id) {
        CashCollectionEntity entity = cashCollectionService.findById(id);
        CashCollectionDto entityDto = cashCollectionAssembler.toModel(entity);
        return new ResponseEntity<>(entityDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CashCollectionDto>> getAll() {
        List<CashCollectionEntity> budgets = cashCollectionService.findAll();
        CollectionModel<CashCollectionDto> entityDtos = cashCollectionAssembler.toCollectionModel(budgets);
        return new ResponseEntity<>(entityDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CashCollectionDto> add(@RequestBody CashCollectionEntity entity) {
        CashCollectionEntity newEntity = cashCollectionService.create(entity);
        CashCollectionDto entDto = cashCollectionAssembler.toModel(newEntity);
        return new ResponseEntity<>(entDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody CashCollectionEntity updateEntity, @PathVariable Integer id) {
        cashCollectionService.update(id, updateEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        cashCollectionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
