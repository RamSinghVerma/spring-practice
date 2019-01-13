
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUpload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*5)   // 50MB

public class FileUpload extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		String name=req.getParameter("name");
		Part filepath=req.getPart("image");
		
		String sql="insert into user(user_name,user_item,file_data) values(?,?,?)";
		try { Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vanisb", "root", "root");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, filepath.getName());
			ps.setBinaryStream(3, filepath.getInputStream(),filepath.getSize());
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("<h1>File uploaded into database successfully</h1>");
				out.println("<a href='index.jsp'> Back </a>");
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
