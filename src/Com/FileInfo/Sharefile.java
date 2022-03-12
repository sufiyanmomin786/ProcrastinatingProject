package Com.FileInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Connection.ConnectionFactory;

/**
 * Servlet implementation class Sharefile
 */
@WebServlet("/Sharefile")
public class Sharefile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
    Statement st=null;
    Statement st1=null;
    Statement st2=null;
    Statement st3=null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    ResultSet resultSet1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sharefile() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] usernamelist = request.getParameterValues("username");
		String[] filenamelist = request.getParameterValues("fskills");
		int Size1=usernamelist.length;
		int Size2=filenamelist.length;
		HttpSession session=request.getSession(true);
		String owneremail=(String)session.getAttribute("email");
		String ownername=(String) session.getAttribute("name");
//		PrintWriter out=response.getWriter();
		if(Size1>Size2)
		{
			for ( int i =0; i < usernamelist.length; i ++ ) {
				
				for ( int j =0;j < filenamelist.length; j ++ ) {
					String email=null;
					String filename=filenamelist[j].toString();
				System.out.println("UserName=>" +  usernamelist[i] + " File Name : " + filenamelist[j]);
				try {
					con=ConnectionFactory.getInstance().getConnection();
				
				st=con.createStatement();
				String qs="select * FROM user WHERE id='"+usernamelist[i]+"'";
					
					resultSet =st.executeQuery(qs);
					
					if(resultSet.next())
					{
						email=resultSet.getString("Email");
					}
					String queryString = "insert into tblaccess(Owner_Name, Owner_Email_ID, File_Name, User_Email_ID) values(?,?,?,?)";
				
					ptmt = con.prepareStatement(queryString);
					ptmt.setString(1,ownername);
					ptmt.setString(2,owneremail);
					ptmt.setString(3,filename);
					ptmt.setString(4,email);
					ptmt.executeUpdate();
					
					
				} catch (SQLException e) {
					// 
					e.printStackTrace();
				}
				}
			}//for	
			
		}// if end
		else
		{
			
for ( int i =0; i < filenamelist.length; i ++ ) {
				
				for ( int j =0;j < usernamelist.length; j ++ ) {
					
					String email=null;
					String filename=filenamelist[j].toString();
				System.out.println("UserName=>" +  usernamelist[i] + " File Name : " + filenamelist[j]);
				try {
					con=ConnectionFactory.getInstance().getConnection();
				
				st=con.createStatement();
				String qs="select * FROM user WHERE id='"+usernamelist[i]+"'";
					
					resultSet =st.executeQuery(qs);
					
					if(resultSet.next())
					{
						email=resultSet.getString("Email");
					}
					String queryString = "insert into tblaccess(Owner_Name, Owner_Email_ID, File_Name, User_Email_ID) values(?,?,?,?)";
				
					ptmt = con.prepareStatement(queryString);
					ptmt.setString(1,ownername);
					ptmt.setString(2,owneremail);
					ptmt.setString(3,filename);
					ptmt.setString(4,email);
					ptmt.executeUpdate();
					
					
				} catch (SQLException e) {
					// 
					e.printStackTrace();
				}
				
				
				}
			
			}//for		
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/File_Share.jsp");
		rd.include(request, response);
		
		
	}

}
