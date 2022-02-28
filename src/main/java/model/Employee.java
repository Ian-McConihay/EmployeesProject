package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Column(name = "employeeName", nullable = false )
	private String name;
	@Column(name = "age", nullable = false)
	private int age;
	@Column(name = "dateJoined", nullable = false)
	private String dateJoined;


	public Employee() {}

	public Employee(Long id, String name, int age, String dateJoined) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateJoined = dateJoined;
	}

	public Employee(Long id, String name, String age, String dateJoined) {
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
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
