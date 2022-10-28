package com.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reviewer {
    private Integer id;
    private String info;
    private Integer film_id;
}
