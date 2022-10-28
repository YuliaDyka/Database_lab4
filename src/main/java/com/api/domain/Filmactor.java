package com.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filmactor {
    private Integer id;
    private Integer film_id;
    private Integer actor_id;
}
