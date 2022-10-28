package com.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Integer amount;
}
