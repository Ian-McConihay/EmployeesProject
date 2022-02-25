package dao;

public class Config {
	public String getUrl() {
		return "jdbc:mysql://localhost:3306/employees_db?allowPublicKeyRetrieval=true&useSSL=false";
	}
	public String getUser() {
		return "root";
	}
	public String getPassword() {
		return "codeup";
	}
}
