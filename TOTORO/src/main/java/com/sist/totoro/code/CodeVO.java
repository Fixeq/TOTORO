package com.sist.totoro.code;

import com.sist.totoro.common.DTO;



public class CodeVO extends DTO {

	private String cd_id   ;    //master code id
	private String d_id    ;    //detail id
	private String d_nm    ;    //detail name
	private String use_yn  ;    //사용여부
	private String ord_num ;    //정열순서
	private String cd_nm   ;	//마스터 코드명
	
	
	@Override
	public String toString() {
		return "CodeVO [cd_id=" + cd_id + ", d_id=" + d_id + ", d_nm=" + d_nm + ", use_yn=" + use_yn + ", ord_num="
				+ ord_num + ", cd_nm=" + cd_nm + "]";
	}


	public String getCd_id() {
		return cd_id;
	}


	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}


	public String getD_id() {
		return d_id;
	}


	public void setD_id(String d_id) {
		this.d_id = d_id;
	}


	public String getD_nm() {
		return d_nm;
	}


	public void setD_nm(String d_nm) {
		this.d_nm = d_nm;
	}


	public String getUse_yn() {
		return use_yn;
	}


	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}


	public String getOrd_num() {
		return ord_num;
	}


	public void setOrd_num(String ord_num) {
		this.ord_num = ord_num;
	}


	public String getCd_nm() {
		return cd_nm;
	}


	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}
	
	
	
	
	
	
	
}
