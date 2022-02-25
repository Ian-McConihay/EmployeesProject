package dao;

public class DaoFactory {
	private static Employees employeesDao;

	private static Config config = new Config();

	public static Employees getEmployeesDao(){
		if (employeesDao == null){
			employeesDao = new MySQLEmployeeDao(config);
		}
		return employeesDao;
	}
}
