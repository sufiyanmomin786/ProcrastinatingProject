package Com.FileInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Blockchain.Block;
import Blockchain.ChainConsensus;
import Com.Connection.ConnectionFactory;
import Com.Connection.Dbconn;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static long starttime=0,endtime=0,total=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareServlet() {
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
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		String[] username = request.getParameterValues("Checkbox");
		String filename =request.getParameter("filename");
		String O_Name="";
		String name=(String)session.getAttribute("O_Name");
		String Owner_Email=(String)session.getAttribute("O_Email_ID");
//		String email="";
		starttime=System.currentTimeMillis();
		
		try {
			for (String s : username) {
				Connection con =ConnectionFactory.getInstance().getConnection();
				Statement st = con.createStatement();
				try {
				String query1 = "select * from file_info where Filename='"+ filename + "' and emailid='"+Owner_Email+"'";
					ResultSet rs1 = st.executeQuery(query1);

					while (rs1.next()) {
						System.out.println("Selected User Name=>" + s);
						O_Name=rs1.getString("Username");
					}
				
					//System.out.println(" From "+ Owner_Email+" To "+s);

					//SendMail.mailSend(name,filename, email);
					
					System.out.println("");

				} catch (Exception e) {
				}
				//String status_msg="0",status="0";
				String Status_U="Pending";
				 PreparedStatement ptmt = null;
				String queryString = "insert into tblaccessnew(Owner_Name, Owner_Email_ID, File_Name, User_Email_ID,Status_U) values(?,?,?,?,?)";
				
				ptmt = con.prepareStatement(queryString);
				ptmt.setString(1,name);
				ptmt.setString(2,Owner_Email);
				ptmt.setString(3,filename);
				ptmt.setString(4,s);
				ptmt.setString(5,Status_U);
				ptmt.executeUpdate();
				//String data=Owner_Email+filename+s;

				String ownername=(Owner_Email);
				String touser=(s);
				String data2=ownername+filename+touser;
				ChainConsensus.Consensus(data2);
				Date timeStamp = new Date();
				String cdate = (String) timeStamp.toString();
				
				 Connection conn4 = (Connection) ConnectionFactory.getInstance().getConnection();
		            
		            String Transcation_Hash=Block.hash;
		            String FromName=ownername;
		            String ToName=touser;
		            String FileName=filename;
		            String ActionData="FileShare";
		            String FileTime=cdate;
		            String DurationTime="0";
		            String OwnerCost="0";
		            String TransferCost="0";
		            String NonceData=String.valueOf(Block.nonce);
		            String PreViewHash="0x";
		            
		            String queryStringmaster = "insert into tblmaster(Transcation_Hash,FromName,ToName,FileName,ActionData,FileTime,DurationTime,OwnerCost,TransferCost,NonceData,PreViewHash) values(?,?,?,?,?,?,?,?,?,?,?)";
		            conn4 =ConnectionFactory.getInstance().getConnection();
					ptmt = conn4.prepareStatement(queryStringmaster);
					ptmt.setString(1,Transcation_Hash);
					ptmt.setString(2,FromName);
					ptmt.setString(3,ToName);
					ptmt.setString(4,FileName);
					ptmt.setString(5,ActionData);
					ptmt.setString(6,FileTime);
					ptmt.setString(7,DurationTime);
					ptmt.setString(8,OwnerCost);
					ptmt.setString(9,TransferCost);
					ptmt.setString(10,NonceData);
					ptmt.setString(11,PreViewHash);
					 ptmt.executeUpdate();
		            
		            // share file 
					
					
					Statement stavailable = con.createStatement();
					ResultSet rsavailable = stavailable
							.executeQuery("select * from request where username='"+s+"' and Filename='"+filename+"' and Ownername='"+Owner_Email+"' and Status='Accept'");
				if(rsavailable.next()) 
				{
					//i=2;
				}
				else
				{
					String KeyandAttribute="KeyandAttribute";
					String a="0",SendRequest="1",ShareSendRequest="1";
					 PreparedStatement ptmt1 = null;
					String queryString1 = "insert into request(username, Filename, Ownername, Status,Status_Msg,RequestName,Duration_Data,SendRequest,ShareSendRequest) values(?,?,?,?,?,?,?,?,?)";
					
					ptmt1 = con.prepareStatement(queryString1);
					ptmt1.setString(1,s);
					ptmt1.setString(2,filename);
					ptmt1.setString(3,Owner_Email);
					ptmt1.setString(4,Status_U);
					ptmt1.setString(5,Status_U);
					ptmt1.setString(6,KeyandAttribute);
					ptmt1.setString(7,a);
					ptmt1.setString(8,SendRequest);
					ptmt1.setString(9,ShareSendRequest);
					ptmt1.executeUpdate();
			}
					String Status="Pending",RequestAuthorName="0";
					 Statement st00=(Statement) con.createStatement();
					 st00.executeUpdate("insert into filerequest (username, Filename, Ownername, Status,RequestAuthorName,OName,U_Status,Smart_Contract_Status,CurrentDate_U,CurrentTime_U,Duration_Data,EndDate_U,EndTime_U) values('"+s+"','"+filename+"','"+Owner_Email+"','"+Status+"','"+RequestAuthorName+"','"+O_Name+"','Pending','Pending','0','0','0','0','0')");	
					
		            
		            
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		endtime=System.currentTimeMillis();
		total=endtime-starttime;
		System.out.println("Current Time=>"+total);
		pw.println("<html><script>alert('File Share Success');</script><body>");
		pw.println("");
		pw.println("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("/File_Share.jsp");
		rd.include(request, response);
	}

}
