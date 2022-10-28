package com.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cash_collection {
    private Integer id;
    private Integer price;
    private Integer film_id;
    private Integer country_id;
}
