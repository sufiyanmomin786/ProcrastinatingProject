package Com.FileDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Connection.SendKeyMail;

/**
 * Servlet implementation class File_Response
 */
@WebServlet("/File_Response")
public class File_Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String attributes1,attributes2,attributes3,attributes4,attributes5;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File_Response() {
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
		
		HttpSession session=request.getSession(false);
		String ownername=request.getParameter("ownername");
		System.out.println("ownername="+ownername);
		String keys=null;
		
		byte[] key = null;
		try 
		{
			ResultSet rs=Dao.user.getfiles(filename,ownername);
			if(rs.next())
			{
//				String a1[]=rs.getString(1).split(":");
//				String a2[]=rs.getString(2).split(":");
//				String a3[]=rs.getString(3).split(":");
//				String a4[]=rs.getString(4).split(":");
//				String a5[]=rs.getString(5).split(":");
//				attributes1=a1[0].toString();
//				attributes2=a2[0].toString();
//				attributes3=a3[0].toString();
//				attributes4=a4[0].toString();
//				attributes5=a5[0].toString();
				keys=rs.getString("P_Key");
			}
			System.out.println("key="+keys);
			
			SendKeyMail.SecretKeySend(filename,user,keys,ownername);
			int i=Dao.user.response(filename, user, ownername, keys);
			if(i>0)
			{
				String msg="Accept";
				String msg1="Key";
				int k=Dao.user.updatestatus(ownername, filename,msg,user,msg1);
				if(k>0)
				{
					System.out.println("Status Updated");
//					out.println("<script type=\"text/javascript\">");  
//					out.println("alert('Status Updated.......');");  
//					out.println("</script>");
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
