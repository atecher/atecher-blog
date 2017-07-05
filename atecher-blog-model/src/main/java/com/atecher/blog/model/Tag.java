package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable{
	private static final long serialVersionUID = -233894904223094938L;
	private Long id;
	private String tag;
	private String code;
	private Integer counts;


}