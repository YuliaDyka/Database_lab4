package com.api.service.impl;

import com.api.domain.Logger;
import com.api.dto.repository.LoggerRepository;
import com.api.exception.LogNotFoundException;
import com.api.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    public Logger findById(Integer id) {
        return loggerRepository.findById(id)
                .orElseThrow(() -> new LogNotFoundException(id));
    }

    public List<Logger> findAll() {
        return loggerRepository.findAll();
    }
}
