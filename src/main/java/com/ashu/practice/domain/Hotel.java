package com.ashu.practice.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Hotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long cityId;

    private String name;

    private String address;

    private String zip;
}
