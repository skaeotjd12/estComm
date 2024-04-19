package com.est.project.contents.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

	private Integer page;
	private Integer pageSize;
	
	public Integer getOffset() {
        return (page-1) * pageSize;
    }
}
