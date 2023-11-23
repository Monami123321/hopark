package com.ssafy.hopark.model.dto;

public class Work {
	private String name;
	private String work1;
	private String work2;
	private String work3;
	private String work4;

	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Work(String name, String work1, String work2, String work3, String work4) {
		super();
		this.name = name;
		this.work1 = work1;
		this.work2 = work2;
		this.work3 = work3;
		this.work4 = work4;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork1() {
		return work1;
	}

	public void setWork1(String work1) {
		this.work1 = work1;
	}

	public String getWork2() {
		return work2;
	}

	public void setWork2(String work2) {
		this.work2 = work2;
	}

	public String getWork3() {
		return work3;
	}

	public void setWork3(String work3) {
		this.work3 = work3;
	}

	public String getWork4() {
		return work4;
	}

	public void setWork4(String work4) {
		this.work4 = work4;
	}

	@Override
	public String toString() {
		return "Work [name=" + name + ", work1=" + work1 + ", work2=" + work2 + ", work3=" + work3 + ", work4=" + work4
				+ "]";
	}

}
