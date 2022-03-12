package Com.AdminInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Connection.ConnectionFactory;

/**
 * Servlet implementation class O_History_Request
 */
@WebServlet("/O_History_Request")
public class O_History_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public O_History_Request() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public static String userid(String name) {
        
        Random r = new Random();
         name ="DO";// name.substring(0,2) + r.nextInt(9) + 1;
         int aNumber = 0;
         aNumber = (int)((Math.random() * 90000)+10000);
        return name+aNumber;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String U_Email=request.getParameter("uemail");
		System.out.println("UEmail=>"+U_Email);
		 Connection con = null;
		try {	

			con=ConnectionFactory.getInstance().getConnection();
			String U_Name = null,U_Password= null,U_Gender= null,U_Role= null,U_Mobile= null,Birth_Date= null;
			Statement sts=con.createStatement();
			ResultSet rs=sts.executeQuery("select * FROM tblowner WHERE O_Email_ID='"+U_Email+"'");
			if(rs.next())
			{
				U_Name=rs.getString("O_Name");
				U_Password=rs.getString("O_Password");
				U_Gender=rs.getString("O_Gender");
				U_Role=rs.getString("O_Role");
				U_Mobile=rs.getString("O_Mobile");
				Birth_Date=rs.getString("Birth_Date");
				
			}
			String U_ID=userid(U_Name);
			
			Statement st=(Statement) con.createStatement();
		String msg="Accept";
		st.executeUpdate("update tblowner set O_Status='"+msg+"',O_Number='"+U_ID+"' where O_Email_ID='"+U_Email+"'");

			} catch (SQLException e) {
		// 
		e.printStackTrace();
	}

		request.getRequestDispatcher("/O_History_Request.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
