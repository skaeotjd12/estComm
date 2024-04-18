package com.est.project.contents.domain;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Board {

	private Integer BRD_SQ;
	private Integer MBR_SQ;
	private String BRD_TTL;
	private String BRD_CONT;
	private String BRD_DEL_YN;
	private Integer BRD_RECMMND_CNT;
	private Integer BRD_VW_CNT;
	private String BRD_SLT_YN;
	private Integer BRD_SLT_CMMT_SQ;
	private String BRD_DIV_CD;
	private String BRD_DTL_DIV_CD;
	private String BRD_NOTI_DIV_CD;
	private String BRD_SLT_DIV_CD;
	private Timestamp BRD_REGIST_DTM;
	private Timestamp BRD_MDFY_DTM;
	
}
