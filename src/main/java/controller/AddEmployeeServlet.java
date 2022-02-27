package controller;

import dao.DaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.AddEmployeeServlet", urlPatterns = "/add-employee")
public class AddEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/add-employee.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		request.getSession().setAttribute("employee", employee);


		Employee newEmployee = new Employee();
		newEmployee = new Employee(
				newEmployee.getId(),
				request.getParameter("name"),
				request.getParameter("age"),
				request.getParameter("dateJoined")
		);
		DaoFactory.getEmployeesDao().insert(newEmployee);
		response.sendRedirect("/index");
	}
}
