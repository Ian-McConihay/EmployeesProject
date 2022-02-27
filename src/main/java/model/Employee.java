package model;

public class Employee {
	private long id;
	private String name;
	private int age;
	private String dateJoined;

	public Employee() {}

	public Employee(long id, String name, int age, String dateJoined) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateJoined = dateJoined;
	}

	public Employee(long id, String name, String age, String dateJoined) {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateJoined(String date) {
		return dateJoined;
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}





}
