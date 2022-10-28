package com.api.domain.service;


import com.api.domain.Nomination;

import java.util.List;

public interface NominationsService extends GeneralService<Nomination, Integer> {
    List<Nomination> FindByFilmId (Integer film_id);
}
