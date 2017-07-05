package com.atecher.blog.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class TreeNode implements Serializable {
	private static final long serialVersionUID = -7475911873396512613L;
	private String code;
	private String text;
	private String href;
	private String parent;
	private List<String> tags;
	private List<TreeNode> nodes;
	
	public String getNodeId() {
		return code;
	}
	

}
