package model;

public class Job extends Employee {
	private long id;
	private String jobTitle;
	private int salary;

	public Job(){}

	public Job(long id, String jobTitle, int salary) {
		this.id = id;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
