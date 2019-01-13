

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="INSERT INTO user(user_name,user_email,user_pass,user_item,gender) VALUES(?,?,?,?,?)";
		if(request.getParameter("name")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
			try{ PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql);
			 ps.setString(1, request.getParameter("name"));
			 ps.setString(2, request.getParameter("email"));
			 ps.setString(3, request.getParameter("password"));
			 ps.setString(4, request.getParameter("items"));
			 ps.setString(5, request.getParameter("gender"));
			 int status=ps.executeUpdate();
			 if(status>0) {
				 RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		 	     rd.forward(request, response);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		
	}

}
