package dao;
import model.Employee;
import java.util.List;

public interface Employees {
	List<Employee> all();
	Long insert(Employee employee);
	void delete(Employee employee);
	Employee uniqueEmployeeId(Long employee);
	List<Employee> searchEmployee(String search);
	List<Employee> allById(Long id);

}
