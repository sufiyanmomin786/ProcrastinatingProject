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
 * Servlet implementation class File_Reject
 */
@WebServlet("/File_Reject")
public class File_Reject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File_Reject() {
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
		try 
		{
		
			{
				String msg="Reject";
				String msg1="Key";
				int k=Dao.user.updatestatus(ownername, filename,msg,user,msg1);
				if(k>0)
				{
					System.out.println("Status Updated");
				}
				else
				{
					System.out.println("Status not updated");
				}
				//response.sendRedirect("Send_path.jsp?user="+user);
			request.getRequestDispatcher("File_Request.jsp").include(request, response);
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
