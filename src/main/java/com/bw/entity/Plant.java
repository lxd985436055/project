package com.bw.entity;

public class Plant {

	private int pid;
	
	private String pname;
	
	private String content;
	
	private int tid;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Plant(int pid, String pname, String content, int tid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.content = content;
		this.tid = tid;
	}

	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plant(String pname, String content, int tid) {
		super();
		this.pname = pname;
		this.content = content;
		this.tid = tid;
	}

	public Plant(int pid, String pname, String content) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.content = content;
	}

	public Plant(String pname, String content) {
		super();
		this.pname = pname;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Plant [pid=" + pid + ", pname=" + pname + ", content=" + content + ", tid=" + tid + "]";
	}
	
	
}
