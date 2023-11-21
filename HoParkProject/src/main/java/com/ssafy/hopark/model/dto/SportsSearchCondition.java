package com.ssafy.hopark.model.dto;

public class SportsSearchCondition {
	private String category;
	private String season;
	private String goal;
	private boolean individual;
	private boolean indoor;
	private boolean hardcore;
	private boolean minor;
	private boolean cost;

	public SportsSearchCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportsSearchCondition(String category, String season, String goal, boolean individual, boolean indoor,
			boolean hardcore, boolean minor, boolean cost) {
		super();
		this.category = category;
		this.season = season;
		this.goal = goal;
		this.individual = individual;
		this.indoor = indoor;
		this.hardcore = hardcore;
		this.minor = minor;
		this.cost = cost;
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
		return "SportsSearchCondition [category=" + category + ", season=" + season + ", goal=" + goal + ", individual="
				+ individual + ", indoor=" + indoor + ", hardcore=" + hardcore + ", minor=" + minor + ", cost=" + cost
				+ "]";
	}

}
