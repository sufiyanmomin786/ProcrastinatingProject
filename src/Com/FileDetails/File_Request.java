package Com.FileDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.user;

/**
 * Servlet implementation class File_Request
 */
@WebServlet("/File_Request")
public class File_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File_Request() {
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
		
		String ownername=request.getParameter("ownername");
		System.out.println("owner="+ownername);
		
		HttpSession session=request.getSession(false);
		String U_Email_ID=(String) session.getAttribute("U_Email_ID");
		System.out.println("U_Email_ID="+U_Email_ID);
		
		String status="Pending";
		String keymsg="Key";
		String m="0";
		int i=user.request(filename, U_Email_ID, ownername,status,keymsg,m);
		if(i==1)
		{
//			out.println("<script type=\"text/javascript\">");  
//			out.println("alert('Request Send Successfully.......');");  
//			out.println("</script>");    
			request.getRequestDispatcher("/File_Access.jsp").include(request, response);
		}
		else if(i==2)
		{
//			out.println("<script type=\"text/javascript\">");  
//			out.println("alert('Request Already Sending.......');");  
//			out.println("</script>");    
			request.getRequestDispatcher("/File_Access.jsp").include(request, response);
		}
		else if(i==0)
		{
//			out.println("<script type=\"text/javascript\">");  
//			out.println("alert('Request Sending Failed.......');");  
//			out.println("</script>");    
			request.getRequestDispatcher("/File_Access.jsp").include(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
