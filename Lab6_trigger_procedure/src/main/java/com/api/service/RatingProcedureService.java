package com.api.service;

import com.api.domain.RaitingsEntity;

public interface RatingProcedureService extends GeneralService<RaitingsEntity, Integer>{
    Float getAvgRating();
}
