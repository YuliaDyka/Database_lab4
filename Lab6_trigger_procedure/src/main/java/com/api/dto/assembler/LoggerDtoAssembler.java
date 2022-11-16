//package com.pavelchak.dto.assembler;
//
//import com.pavelchak.controller.LoggerController;
//import com.pavelchak.domain.Logger;
//import com.pavelchak.dto.LoggerDto;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.stereotype.Component;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//
//@Component
//public class LoggerDtoAssembler implements RepresentationModelAssembler<Logger, LoggerDto> {
//    @Override
//    public LoggerDto toModel(Logger entity) {
//        LoggerDto loggerDto = LoggerDto.builder()
//                .id(entity.getId())
//                .person(entity.getPerson())
//                .book(entity.getBook())
//                .action(entity.getAction())
//                .timeStamp(entity.getTimeStamp())
//                .user(entity.getUser())
//                .build();
//        Link selfLink = linkTo(methodOn(LoggerController.class).getLog(loggerDto.getId())).withSelfRel();
//        loggerDto.add(selfLink);
//        return loggerDto;
//    }
//
//    @Override
//    public CollectionModel<LoggerDto> toCollectionModel(Iterable<? extends Logger> entities) {
//        CollectionModel<LoggerDto> loggerDto = RepresentationModelAssembler.super.toCollectionModel(entities);
//        Link selfLink = linkTo(methodOn(LoggerController.class).getAllLogs()).withSelfRel();
//        loggerDto.add(selfLink);
//        return loggerDto;
//    }
//}
