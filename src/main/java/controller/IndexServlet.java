package controller;

import dao.DaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("allEmployees", DaoFactory.getEmployeesDao().all());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
