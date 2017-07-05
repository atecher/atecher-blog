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
public class UserRole implements Serializable {
    private static final long serialVersionUID = -2831446063448677401L;
    private Long user_id;
    private Long role_id;
    private String session_type;
    private Date valid_from;
    private Date valid_to;
}
