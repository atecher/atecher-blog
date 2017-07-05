package com.atecher.blog.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 2438037063942588690L;
	private int total;
	private List<T> rows;
}
