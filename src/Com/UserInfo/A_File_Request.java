package Com.UserInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class A_File_Request
 */
@WebServlet("/A_File_Request")
public class A_File_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_File_Request() {
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
        String ownereemail=dd[0].toString();
        String filename=dd[1].toString();
        String ownername=dd[2].toString();
        String emailid=(String) session.getAttribute("U_Email_ID");
        System.out.println("Owner Email=>"+ownereemail+"\t File Name=>"+filename+"\t User Email=>"+emailid);
        try
		{			
			int i=0;
			Connection con=ConnectionFactory.getInstance().getConnection();
			Statement st=(Statement) con.createStatement();
			Statement stavailable = con.createStatement();
			ResultSet rsavailable = stavailable
					.executeQuery("select * from request where username='"+emailid+"' and Filename='"+filename+"' and Ownername='"+ownereemail+"' and SendRequest='0'");
		if(rsavailable.next()) 
		{
			i=2;
		}
		else
		{
			String Status="Pending",RequestAuthorName="0";
			 i=1;
			 
		 st.executeUpdate("insert into filerequest (username, Filename, Ownername, Status,RequestAuthorName,OName,U_Status,Smart_Contract_Status,CurrentDate_U,CurrentTime_U,Duration_Data,EndDate_U,EndTime_U) values('"+emailid+"','"+filename+"','"+ownereemail+"','"+Status+"','"+RequestAuthorName+"','"+ownername+"','Pending','Pending','0','0','0','0','0')");	
		 Statement st1=(Statement) con.createStatement();
		 st1.executeUpdate("update file_info set status_o='"+Status+"' where emailid='"+ownereemail+"' and Filename='"+filename+"' ");	
		 String Status_U="Pending";
		 String KeyandAttribute="KeyandAttribute";
			String a="0",SendRequest="0",ShareSendRequest="0";
			 PreparedStatement ptmt1 = null;
			String queryString1 = "insert into request(username, Filename, Ownername, Status,Status_Msg,RequestName,Duration_Data,SendRequest,ShareSendRequest) values(?,?,?,?,?,?,?,?,?)";
			
			ptmt1 = con.prepareStatement(queryString1);
			ptmt1.setString(1,emailid);
			ptmt1.setString(2,filename);
			ptmt1.setString(3,ownereemail);
			ptmt1.setString(4,Status_U);
			ptmt1.setString(5,Status_U);
			ptmt1.setString(6,KeyandAttribute);
			ptmt1.setString(7,a);
			ptmt1.setString(8,SendRequest);
			ptmt1.setString(9,ShareSendRequest);
			ptmt1.executeUpdate();
		 
		 
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        RequestDispatcher dispatcher=request.getRequestDispatcher("/All_U_Request_File.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
