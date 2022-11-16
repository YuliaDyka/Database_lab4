package com.api.service;

import com.api.domain.Logger;

import java.util.List;

public interface LoggerService {
    List<Logger> findAll();
    Logger findById(Integer id);
}
