package dao;
import java.sql.DriverManager;

import com.google.protobuf.Internal;
import com.mysql.cj.jdbc.Driver;
import model.Employee;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;

public class MySQLEmployeeDao implements Employees {
	private final Connection connection;

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
			throw new RuntimeException("Error retrieving all employee.", e);
		}
	}



	@Override
	public Long insert(Employee employee) {
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		try {
			String insertQuery = "INSERT INTO employees_db.employees( name, age, date_joined) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, date);
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			resultSet.next();
			return resultSet.getLong(1);
		} catch (SQLException e) {
			throw new RuntimeException("Error creating a new employee.", e);
		}
	}

	@Override
	public void delete(Employee employee) {
		try {
			String deleteQuery = "DELETE FROM employees_db.employees WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, employee.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error deleting employee", e);
		}
	}

	@Override
	public Employee uniqueEmployeeId(Long employee) {
		String query = "SELECT * FROM employees_db.employees WHERE id = ? LIMIT 1";
		ResultSet resultSet;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, employee);
			resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				return null;
			}
			return extractEmployee(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException("Error finding employee ID", e);
		}
	}

		private Employee extractEmployee (ResultSet resultSet){
			try {
				return new Employee(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getInt("age"),
						resultSet.getString("date_joined")

						);
			} catch (SQLException e) {
				throw new RuntimeException("Error extracting employee", e);
			}
		}

		private List<Employee> createEmployeeFromResults (ResultSet resultSet){
			try {
				List<Employee> employeeList = new LinkedList<>();
				while (resultSet.next()) {
					employeeList.add(extractEmployee(resultSet));
				}
				return employeeList;
			} catch (SQLException e) {
				throw new RuntimeException("Error creating employee", e);
			}
		}


	@Override
	public List<Employee> searchEmployee(String search) {
		try {
			List<Employee> employeeList = new ArrayList<>();
			String searchQuery = "SELECT id FROM employees_db.employees WHERE name LIKE ?";
			PreparedStatement statement = connection.prepareStatement(searchQuery, Statement.NO_GENERATED_KEYS);
			statement.setString(1, "%" + search + "%");
			statement.executeQuery();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				employeeList.add(uniqueEmployeeId(resultSet.getLong("id")));
			}
			return employeeList;
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving searched employee", e);
		}
	}

	@Override
	public List<Employee> allById(Long id) {
		String query = "SELECT * FROM employees_db.employees WHERE employees_db.employees.id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			return createEmployeeFromResults(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException("Error finding employee ID", e);
		}
	}


}
