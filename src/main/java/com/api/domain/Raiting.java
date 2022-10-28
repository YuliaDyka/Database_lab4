package com.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Raiting {
    private Integer id;
    private Integer raiting;
    private Integer film_id;
}
