package com.ssafy.hopark.model.dto;

public class Sports {
	private String name;
	private String engName;
	private String category;
	private String season;
	private String goal;
	private boolean individual;
	private boolean indoor;
	private boolean hardcore;
	private boolean minor;
	private boolean cost;

	public Sports() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public boolean isIndoor() {
		return indoor;
	}

	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}

	public boolean isHardcore() {
		return hardcore;
	}

	public void setHardcore(boolean hardcore) {
		this.hardcore = hardcore;
	}

	public boolean isMinor() {
		return minor;
	}

	public void setMinor(boolean minor) {
		this.minor = minor;
	}

	public boolean isCost() {
		return cost;
	}

	public void setCost(boolean cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Sports [name=" + name + ", engName=" + engName + ", category=" + category + ", season=" + season
				+ ", goal=" + goal + ", individual=" + individual + ", indoor=" + indoor + ", hardcore=" + hardcore
				+ ", minor=" + minor + ", cost=" + cost + "]";
	}

}
