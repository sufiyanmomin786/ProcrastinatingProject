package Com.UserInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.JavaX;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Connection.ConnectionFactory;

/**
 * Servlet implementation class U_File_Request
 */
@WebServlet("/U_File_Request")
public class U_File_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_File_Request() {
        super();
        JavaX.initComponents();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d=request.getParameter("name");
		HttpSession session=request.getSession();
        String[] dd=d.split(",");
        String ownername=dd[0].toString();
        String filename=dd[1].toString();
        String emailid=(String) session.getAttribute("U_Email_ID");
        System.out.println("Owner Name=>"+ownername+"\t File Name=>"+filename+"\t User Email=>"+emailid);
        try
		{			
			int i=0;
			Connection con=ConnectionFactory.getInstance().getConnection();
			Statement st=(Statement) con.createStatement();
			Statement stavailable = con.createStatement();
			ResultSet rsavailable = stavailable
					.executeQuery("select * from filerequest where username='"+emailid+"' and Filename='"+filename+"' and Ownername='"+ownername+"'");
		if(rsavailable.next()) 
		{
			i=2;
		}
		else
		{
			String Status="Pending",RequestAuthorName="0";
			 i=1;
		 st.executeUpdate("insert into filerequest (username, Filename, Ownername, Status,RequestAuthorName) values('"+emailid+"','"+filename+"','"+ownername+"','"+Status+"','"+RequestAuthorName+"')");	
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        RequestDispatcher dispatcher=request.getRequestDispatcher("/Smart_Cont_Access.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
