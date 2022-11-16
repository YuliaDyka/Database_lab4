//package com.pavelchak.controller;
//
//import com.pavelchak.domain.Logger;
//import com.pavelchak.dto.LoggerDto;
//import com.pavelchak.dto.assembler.LoggerDtoAssembler;
//import com.pavelchak.service.LoggerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/logs")
//public class LoggerController {
//    @Autowired
//    private LoggerService loggerService;
//    @Autowired
//    private LoggerDtoAssembler loggerDtoAssembler;
//
//    @GetMapping(value = "/{logId}")
//    public ResponseEntity<LoggerDto> getLog(@PathVariable Integer logId) {
//        Logger logger = loggerService.findById(logId);
//        LoggerDto loggerDto = loggerDtoAssembler.toModel(logger);
//        return new ResponseEntity<>(loggerDto, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "")
//    public ResponseEntity<CollectionModel<LoggerDto>> getAllLogs() {
//        List<Logger> loggers = loggerService.findAll();
//        CollectionModel<LoggerDto> loggerDtos = loggerDtoAssembler.toCollectionModel(loggers);
//        return new ResponseEntity<>(loggerDtos, HttpStatus.OK);
//    }
//}
