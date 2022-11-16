package com.api.service;

import com.api.domain.RaitingsEntity;
import com.api.service.GeneralService;

public interface RatingProcedureService extends GeneralService<RaitingsEntity, Integer>{
    double getAvgRating();
}
