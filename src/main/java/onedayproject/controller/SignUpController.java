package onedayproject.controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onedayproject.dao.UserDAO;
import onedayproject.model.User;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User user;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        this.user = new User();
        this.userDAO = new UserDAO();
    }
    
    public SignUpController(User user,UserDAO userDAO){
    	this.user = user;
    	this.userDAO = userDAO;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("passwordcon");
		String postcode = request.getParameter("postcode");
		String house = request.getParameter("house");
		
		if(password.equals(confirmpassword)){
			if(ValidatePostcode.validate(postcode)){
				user = new User(email,password,postcode,house);
				userDAO = new UserDAO();
				try{
					userDAO.save(user);
				}catch (RollbackException e) {
					request.setAttribute("System Problem", "Sorry Technical Difficulties Please try again later");
					request.getRequestDispatcher("./newuser.jsp").forward(request, response);				
				}
				userDAO.close();
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				request.setAttribute("signupcomplete", "Welcome " + email +" We look forward to providing all of your dairy needs");
				request.getRequestDispatcher("./order.jsp").forward(request, response);
			}else{
				request.setAttribute("PostCode Problem", "I'm sorry we are not yet delivering to that postcode");
				request.getRequestDispatcher("./newuser.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("Password Problem", "The Passwords do not match try again!");
			request.getRequestDispatcher("./newuser.jsp").forward(request, response);
		}
		
	}

}
