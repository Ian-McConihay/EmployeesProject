package dao;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
import model.Employee;

import java.sql.*;
import java.util.List;


public class MySQLEmployeeDao implements Employees {
	private Connection connection;

	@Override
	public List<Employee> all() {
		return null;
	}

	@Override
	public Long insert(Employee employee) {
		return null;
	}

	@Override
	public void delete(Employee employee) {

	}

	@Override
	public Employee uniqueEmployeeId(Long employee) {
		return null;
	}

	@Override
	public List<Employee> searchEmployee(String search) {
		return null;
	}

	@Override
	public List<Employee> allById(Long id) {
		return null;
	}
}
