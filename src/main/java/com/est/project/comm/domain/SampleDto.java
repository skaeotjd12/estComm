package com.est.project.comm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter, setter, tostring, equalandhashcode,requiredargsconstructer 합쳐놈
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto {
	
	private int MBR_SQ;
	private String MBR_ID;
	private String MBR_PW;
	private String MBR_NM;
	
}
