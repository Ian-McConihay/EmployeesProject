package dao;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
import model.Employee;

import java.sql.*;
import java.util.List;


public class MySQLEmployeeDao implements Employees {
	private Connection connection;

	public MySQLEmployeeDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUser(),
					config.getPassword()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to the database!", e);
		}
	}

	@Override
	public List<Employee> all() {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM employees_db.employees");
			ResultSet resultSet = statement.executeQuery();
			return createEmployeeFromResults(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving all posts.", e);
		}
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
