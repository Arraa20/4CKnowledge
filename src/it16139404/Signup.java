package it16139404;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String[] interests;
		String interestConcat = "";
		
		try
		{	     		
			 
		     MemberBean member = new MemberBean();
		     member.setUserName(request.getParameter("username"));
		     member.setDOB(request.getParameter("dob"));
		     member.setEmail(request.getParameter("email"));
		     member.setPhoneNumber(request.getParameter("phonenumber"));
		     member.setAddress(request.getParameter("address"));
		     member.setPassword(request.getParameter("password"));
		     
		     interests = request.getParameterValues("interests");
		     for(String value : interests)
		     {
		    	 interestConcat = interestConcat + " " + value;
		     }  
		     
		     // Add interests
		     member.setInterest(interestConcat);

		     MemberDAO.addMemberDetails(member);

		} 	
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		
	}

}
