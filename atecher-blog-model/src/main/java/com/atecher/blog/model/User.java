package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 7041952897033878259L;

    private Long userId;

    private String nickName;

    private String regEmail;

    private String realName;

    private String sex;

    private Date birthday;

    private Date lastLoginTime;

    private Integer logins;

    private String valid;

    private Date regTime;

    private String summary;

    private String avatar;


}