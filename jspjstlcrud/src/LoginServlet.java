

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

	          
	    String userName=request.getParameter("name");
	    String userPass=request.getParameter("password");
	    
	    if(userName==null || userPass==null || userName.isEmpty() || userPass.isEmpty()) {
	    	response.sendRedirect(request.getContextPath());
	    }
	   
	   // System.out.println("login servlet...........");
	    String query="SELECT * FROM USER where user_name=? and user_pass=?";
	   /* String user = (String) request.getSession().getAttribute("user");
	    if (null == user) {
	       request.setAttribute("Error", "Session has ended.  Please login.");
	        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	       rd.forward(request, response); 
	       System.out.println("context path="+request.getContextPath());
	       response.sendRedirect(request.getContextPath());
	    }*/
	    
	    try { 
	    	PreparedStatement ps=DBConnection.getConnection().prepareStatement(query);
	    	ps.setString(1, userName);
	    	ps.setString(2, userPass);
	    	ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
	    	HttpSession session=request.getSession(true);
	    	session.setAttribute("user", userName);
	    	 RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
	 	     rd.forward(request, response);
	    }else {
	    	response.sendRedirect(request.getContextPath());
	    }
	    	
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	

}
