package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Role  implements Serializable {
	private static final long serialVersionUID = 7412463266304856995L;
	private Long role_id;
	private String role_code;
	private String role_name;
	private String role_desc;
}
