package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
import java.util.List;


@Data

@NoArgsConstructor
@AllArgsConstructor
public class AuthUser implements Serializable {
    private Long id;
    private String account;
    private String password;
    private String name;
    private String avatar;
    private List<String> roles;
}
