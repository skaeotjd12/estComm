package com.est.project.comm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter, setter, tostring, equalandhashcode,requiredargsconstructer 합쳐놈
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto {
	
	private int mbr_Sq;
	private String mbr_Id;
	private String mbr_Pw;
	private String mbr_Nm;
	
}
