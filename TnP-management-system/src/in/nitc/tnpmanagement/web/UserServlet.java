package in.nitc.tnpmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nitc.tnpmanagement.dao.CompanyDAO;
import in.nitc.tnpmanagement.dao.UserDAO;
import in.nitc.tnpmanagement.model.Company;
import in.nitc.tnpmanagement.model.User;
import in.nitc.tnpmanagement.model.User_company;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private CompanyDAO companyDAO;
	
	public void init() {
		userDAO = new UserDAO();
		companyDAO = new CompanyDAO();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession session = request.getSession(false);
		try {
			switch(action) {
			case "/home":
				User user;
				user = (User)session.getAttribute("sessuser");
				if(user != null) {
				   //for students
				     if (user.getIsPlacOff() == 0) {
					    viewHome(request, response);
				     }
				   //for PO
				     else {
					    viewHomeAdmin(request, response);
				     }
				} else {
					throw new IOException("Unauthorized Access");
					// userEntry(request, response);
				}
				break;
			case "/login":
				loginUser(request, response);
				break;
			case "/signup":
				signupUser(request, response);
				break;
			case "/edit-company":
				showEditFormCompany(request, response);
				break;
			case "/update-company":
				updateCompany(request, response);
				break;
			case "/edit":
				showEditFormUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/apply":
				applyUser(request, response);
				break;
			case "/logout":
				userLogout(request, response);
				break;
			case "/assign":
				showAssignForm(request, response);
				break;
			case "/assigned":
				assignUser(request, response);
				break;
			
			default:
				userEntry(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (IOException e) {
			System.err.println(e);
		}
	}	
		
		private void userEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("welcomeUser.jsp");
		}
		
		private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			
			String regNo = request.getParameter("regNo");
			String pwd = request.getParameter("password");
			User user = userDAO.loginUser(regNo, pwd);
			
			if (user.getId() == -1) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				request.setAttribute("Err", 1);
				dispatcher.forward(request, response);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("sessuser", user);
			response.sendRedirect("/home");
			
		}
		
		private void signupUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String name = request.getParameter("name");
			String regNo = request.getParameter("regNo");
			String email = request.getParameter("email");
			String phNo = request.getParameter("phNo");
			float cgpa = Float.parseFloat(request.getParameter("cgpa"));
			String password = request.getParameter("password");
			
			User newUser = new User(name,regNo,email,password,phNo,cgpa,"NOT PLACED","N/A",0);
			userDAO.registerUser(newUser);
			response.sendRedirect("Welcome Page");
		}
		
		private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession(false);
			User user;
			user = (User)session.getAttribute("sessuser");
			List<Company> tempListCompany = companyDAO.selectAllCompany(), listCompany = new ArrayList<>();
			for (Company company : tempListCompany) {
				if(companyDAO.checkApplied(user.getId(), company.getId())) {
					company.setApplied(true);
				} else {
					company.setApplied(false);
				}
				listCompany.add(company);
			}
			request.setAttribute("listCompany", listCompany);
			request.setAttribute("USER", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeStudent.jsp");
			dispatcher.forward(request, response);
		}

		private void viewHomeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession(false);
			User user;
			user = (User)session.getAttribute("sessuser");
			List<Company> listCompany = companyDAO.selectAllCompany();
			List<User> listStudent = userDAO.selectAllStudents();

			request.setAttribute("listCompany", listCompany);
			request.setAttribute("listStudent", listStudent);
			
			request.setAttribute("USER", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
		private void showEditFormCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			int id = Integer.parseInt(request.getParameter("id"));
			Company existingCompany = companyDAO.selectCompany(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("companyForm.jsp");
			request.setAttribute("company", existingCompany);
			dispatcher.forward(request, response);		
		}
		
		private void updateCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String role = request.getParameter("role");
			String ctc = request.getParameter("ctc");
			String loc = request.getParameter("loc");

			Company company = new Company(id, name, role, ctc, loc);
			companyDAO.updateCompany(company);
			response.sendRedirect("/home");
		}
		
		private void showEditFormUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession(false);
			User user;
			user = (User)session.getAttribute("sessuser");
			RequestDispatcher dispatcher = request.getRequestDispatcher("userForm.jsp");
			request.setAttribute("user", user);
			dispatcher.forward(request, response);	
		}
		
		private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String regNo = request.getParameter("regNo");
			String email = request.getParameter("email");
			String phNo = request.getParameter("phNo");
			float cgpa = Float.parseFloat(request.getParameter("cgpa"));
			String password = request.getParameter("password");
			

			User user = new User(id, name, regNo, email, password, phNo, cgpa, "DOESNT MATTER", "DOESNT MATTER", 0);
			userDAO.updateUser(user);
			response.sendRedirect("/home");
		}
		
		private void applyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			HttpSession session = request.getSession(false);
			int c_id = Integer.parseInt(request.getParameter("id"));
			User user;
			user = (User)session.getAttribute("sessuser");
			int u_id = user.getId();
			User_company company_applying = new User_company(u_id,c_id);
			companyDAO.applyToCompany(company_applying);
			response.sendRedirect("/home");			
		}
		
		private void userEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			response.sendRedirect("welcomeUser.jsp");
		}
		private void userEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			response.sendRedirect("welcomeUser.jsp");
		}
		private void userEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			response.sendRedirect("welcomeUser.jsp");
		}
		
		
		
		
	
	
}
