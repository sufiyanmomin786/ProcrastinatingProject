package Com.FileInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class RevokeFile
 */
@WebServlet("/RevokeFile")
public class RevokeFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevokeFile() {
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
		
		String Owner_Email=(String)session.getAttribute("O_Email_ID");
		try {
			for (String s : username) {
				Connection con =ConnectionFactory.getInstance().getConnection();
				String qs="delete from tblaccessnew where File_Name='"+filename+"' and Owner_Email_ID='"+Owner_Email+"' and User_Email_ID='"+s+"'";
				Statement st1=con.createStatement();
				st1.executeUpdate(qs);
				String ownername=Owner_Email;
				String touser=s;
				String data2=ownername+filename+touser+"#"+"Revoke";
				//Block.calculateHash(data2);
				ChainConsensus.Consensus(data2);
				Date timeStamp = new Date();
				String cdate = (String) timeStamp.toString();
				
				
				 Connection conn4 = (Connection) ConnectionFactory.getInstance().getConnection();
		            Statement stat4 = (Statement) conn4.createStatement();
		            stat4.executeUpdate("insert into tblaccess_revoke(PlainData,BlocKData,PreviousHash,Current_Times,Nonce) values ('" + data2 +"','" + Block.hash +"','" + Dbconn.PrevHash4 +"','" + cdate +"','" + Block.nonce +"')");
			   
		            String Transcation_Hash=Block.hash.toString();
		            String FromName=ownername;
		            String ToName=touser;
		            String FileName=filename;
		            String ActionData="FileRevoke";
		            String FileTime=cdate;
		            String DurationTime="0";
		            String OwnerCost="0";
		            String TransferCost="0";
		            String NonceData=String.valueOf(Block.nonce);
		            String PreViewHash="0x";
		            PreparedStatement ptmt = null;
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
		            
		            
		            
		            
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<html><script>alert('File Revoke Success');</script><body>");
		pw.println("");
		pw.println("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("/Revoke_File_Share.jsp");
		rd.include(request, response);
	}

}
