package com.telusko.model;

public class meminfo {
	private int memberid;
	private int cellno;
	
	public meminfo() {
		super();
	}
	public meminfo(Integer id) {
		super();
		this.memberid = id;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getCellno() {
		return cellno;
	}
	public void setCellno(int cellno) {
		this.cellno = cellno;
	}

}
