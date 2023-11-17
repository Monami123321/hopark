package com.ssafy.hopark.model.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String location;
	private String email;
	private int age;
	private String img;
	private String orgImg;
	private String work1;
	private String work2;
	private String work3;
	private String work4;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String password, String name, String location, String email, int age, String img,
			String orgImg, String work1, String work2, String work3, String work4) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.location = location;
		this.email = email;
		this.age = age;
		this.img = img;
		this.orgImg = orgImg;
		this.work1 = work1;
		this.work2 = work2;
		this.work3 = work3;
		this.work4 = work4;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
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
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", location=" + location + ", email="
				+ email + ", age=" + age + ", img=" + img + ", orgImg=" + orgImg + ", work1=" + work1 + ", work2="
				+ work2 + ", work3=" + work3 + ", work4=" + work4 + "]";
	}

}
