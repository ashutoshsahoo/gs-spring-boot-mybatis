package com.ashu.practice.domain;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class City implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String state;

    private String country;
}
