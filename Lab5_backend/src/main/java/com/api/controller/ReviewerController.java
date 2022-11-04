package com.api.controller;

import com.api.domain.ReviewersEntity;
import com.api.dto.ReviewerDto;
import com.api.dto.assembler.ReviewerAssembler;
import com.api.service.ReviewersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/reviewers")
public class ReviewerController {
    @Autowired
    private ReviewersService reviewersService;
    @Autowired
    private ReviewerAssembler reviewerAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReviewerDto> getById(@PathVariable Integer id) {
        ReviewersEntity entity = reviewersService.findById(id);
        ReviewerDto budgetDtoDto = reviewerAssembler.toModel(entity);
        return new ResponseEntity<>(budgetDtoDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ReviewerDto>> getAll() {
        List<ReviewersEntity> reviewersEntities = reviewersService.findAll();
        CollectionModel<ReviewerDto> reviewerDtos = reviewerAssembler.toCollectionModel(reviewersEntities);
        return new ResponseEntity<>(reviewerDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ReviewerDto> addBudget(@RequestBody ReviewersEntity entity) {
        ReviewersEntity newRev = reviewersService.create(entity);
        ReviewerDto revDto = reviewerAssembler.toModel(newRev);
        return new ResponseEntity<>(revDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBudget(@RequestBody ReviewersEntity updateBudget, @PathVariable Integer id) {
        reviewersService.update(id, updateBudget);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable Integer id) {
        reviewersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
