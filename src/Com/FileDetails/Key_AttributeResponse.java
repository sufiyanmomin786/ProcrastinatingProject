package Com.FileDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Connection.ConnectionFactory;
import Com.Connection.SendKeyMail;

/**
 * Servlet implementation class Key_AttributeResponse
 */
@WebServlet("/Key_AttributeResponse")
public class Key_AttributeResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Key_AttributeResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String filename=request.getParameter("filename");
		System.out.println("Filename="+filename);
		String user=request.getParameter("user");
		System.out.println("user="+user);
		
		//HttpSession session=request.getSession(false);
		String ownername=request.getParameter("ownername");
		System.out.println("ownername="+ownername);
		String keys=null;
		String attributes1=null,attributes2=null,attributes3=null,attributes4=null,attributes5=null,attributes6=null;
		//byte[] key = null;
		try 
		{
			
			ResultSet rs=Dao.user.getfiles01(filename,ownername);
			if(rs.next())
			{
				String a1[]=rs.getString(1).split(":");
				String a2[]=rs.getString(2).split(":");
				String a3[]=rs.getString(3).split(":");
				String a4[]=rs.getString(4).split(":");
				String a5[]=rs.getString(5).split(":");
				String a6[]=rs.getString(10).split(":");
				attributes1=a1[0].toString();
				attributes2=a2[0].toString();
				attributes3=a3[0].toString();
				attributes4=a4[0].toString();
				attributes5=a5[0].toString();
				attributes6=a6[0].toString();
				
			}
			String q="select * from file_info where Filename='"+filename+"' and emailid='"+ownername+"'";
		Connection	con=ConnectionFactory.getInstance().getConnection();
		Statement	st=con.createStatement();
		ResultSet rs1=st.executeQuery(q);
		if(rs1.next())
		{
			keys=rs1.getString("P_Key");
			
		}
			System.out.println("key="+keys);
			
			//SendKeyMail.SecretattributeSend(filename,user,keys,ownername,attributes1,attributes2,attributes3,attributes4,attributes5,attributes6);
			int i=Dao.user.response(filename, user, ownername, keys);
			if(i>0)
			{
				String msg="Accept";
				String msg1="KeyandAttribute";
				int k=Dao.user.updatestatus(ownername, filename,msg,user,msg1);
				if(k>0)
				{
					System.out.println("Status Updated");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Status Updated.......');");  
					out.println("</script>");
				}
				else
				{
					System.out.println("Status not updated");
				}
				//response.sendRedirect("Send_path.jsp?user="+user);
			request.getRequestDispatcher("File_Request.jsp").include(request, response);
			}
			else
			{
//				out.println("<script type=\"text/javascript\">");  
//				out.println("alert('Response Send Failed.......');");  
//				out.println("</script>");    
				request.getRequestDispatcher("/File_Request.jsp").include(request, response);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
