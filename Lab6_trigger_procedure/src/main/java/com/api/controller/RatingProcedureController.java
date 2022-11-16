package com.api.controller;

import com.api.domain.CountryInfo;
import com.api.dto.CountryInfoDto;
import com.api.dto.assembler.CountryInfoAssembler;
import com.api.dto.assembler.RaitingAssembler;
import com.api.service.CountryInfoProcedureService;
import com.api.service.RatingProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rating_procedure")
public class RatingProcedureController {

    @Autowired
    RatingProcedureService ratingProcedureService;
    @Autowired
    private RaitingAssembler raitingAssembler;

    @GetMapping(value = "/getAvg")
    public double getAvgRating() {

        var result = ratingProcedureService
                .getAvgRating();

        return result;
    }
}
