package Com.UserInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
import Dao.user;

/**
 * Servlet implementation class updateSmart
 */
@WebServlet("/updateSmart")
public class updateSmart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement ptmt = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateSmart() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	public static String convert(String cost) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String currenttime = "";
		if (cost.equals("5#Min")) {
			Date dNow = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dNow);
			cal.add(Calendar.MINUTE, 5);
			dNow = cal.getTime();
			currenttime = sdf.format(dNow);
			//System.out.println("time=>" + dNow);
		} else if (cost.equals("10#Min")) {
			Date dNow = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dNow);
			cal.add(Calendar.MINUTE, 10);
			dNow = cal.getTime();
			currenttime = sdf.format(dNow);
			//System.out.println("time=>" + dNow);
		} else if (cost.equals("15#Min")) {
			Date dNow = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dNow);
			cal.add(Calendar.MINUTE, 15);
			dNow = cal.getTime();
			currenttime = sdf.format(dNow);
			//System.out.println("time=>" + dNow);
		} else if (cost.equals("20#Min")) {
			Date dNow = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dNow);
			cal.add(Calendar.MINUTE, 20);
			dNow = cal.getTime();
			currenttime = sdf.format(dNow);
			//System.out.println("time=>" + dNow);
		} else if (cost.equals("30#Min")) {
			Date dNow = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(dNow);
			cal.add(Calendar.MINUTE, 30);
			dNow = cal.getTime();
			currenttime = sdf.format(dNow);
			//System.out.println("time=>" + dNow);
		}
		return currenttime;

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String daycon = request.getParameter("attribute_1");
		String dbownercost = "", dbO_Name = "";
		String[] dd = daycon.split("#");
		String availablecost = request.getParameter("availablecost");
		String costtransfer = request.getParameter("costtransfer");
		HttpSession session = request.getSession(true);
		String emailid = (String) session.getAttribute("U_Email_ID");
		double count = Double.valueOf(costtransfer) * Integer.valueOf(dd[0]);

		double count1 = Double.valueOf(availablecost);
		String ownername1 = request.getParameter("ownername");
		String filename = request.getParameter("O_filename");
		try {

			String status1 = "Pending";
			String keymsg = "KeyandAttribute";

			connection = ConnectionFactory.getInstance().getConnection();
			// User Account cost add and sub
			String ownercost = null;
			Statement st1 = connection.createStatement();
			ResultSet rs = st1
					.executeQuery("select * from tblSmart_Contracts where Duration_Data='"
							+ daycon.toString() + "'");
			if (rs.next()) {
				ownercost = rs.getString("Owner_Cost");
			}
			dbownercost = ownercost;
			double Owner_Cost = Double.valueOf(ownercost);
			double tranowner = count + Owner_Cost;
			if (tranowner > count1) {

			} else {
				double finalcount = count1 - count;
				System.out.println("Rate of Cost Transfer" + costtransfer
						+ "\tTransfer Count" + count + "Minutes=>" + dd[0]
						+ "\tOwner_Cost" + Owner_Cost);
				System.out.println();
				double finalcountnew = finalcount - Owner_Cost;

				DecimalFormat df2 = new DecimalFormat("###.###");
				Statement st = connection.createStatement();
				String queryString = "update tblUserName set Cost_Data='"
						+ df2.format(finalcountnew) + "' where Email_ID='"
						+ emailid + "'";
				st.executeUpdate(queryString);
				// owner account save cost
				String ownercount = null;
				String ownername = (String) session.getAttribute("ownername");
				Statement st01 = connection.createStatement();
				ResultSet rs0 = st01
						.executeQuery("select * from tblOwnerName where Email_ID='"
								+ ownername1 + "'");
				if (rs0.next()) {
					ownercount = rs0.getString("Cost_Data");
				}
				double ownerfinal = Double.valueOf(ownercount) + Owner_Cost;
				session.setAttribute("Account_Balances", ownerfinal);
				Statement sts = connection.createStatement();
				String queryString1 = "update tblOwnerName set Cost_Data='"
						+ ownerfinal + "' where Email_ID='" + ownername + "'";
				sts.executeUpdate(queryString1);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
				Date date1 = new Date();
				String currentdate = sdf.format(date1);
				String currenttime = sdftime.format(date1);
				String Duration_Time = "0";// convert(daycon);

				//
				user.request(filename, emailid, ownername1, status1, keymsg,
						daycon);

				//String[] dayss = daycon.split("#");
				Statement st001 = connection.createStatement();
				String status = "Working";
				String O_Name = request.getParameter("ownername");
				dbO_Name = O_Name;
				String O_FileName = request.getParameter("O_filename");

				currenttime = convert(daycon);// end time
				Date d1 = new Date();
				String start = sdf.format(d1);
				Date dNow = new Date();
				Calendar cal = Calendar.getInstance();
				dNow = cal.getTime();
				SimpleDateFormat csdf = new SimpleDateFormat("HH:mm:ss");

				Duration_Time = csdf.format(dNow);
				System.out.println("Start Time=>"+Duration_Time+"\t End Time=>"+currenttime);
				LocalDate dateBefore = LocalDate.parse(start);
			
				long noOfDaysBetween = (ChronoUnit.DAYS.between(dateBefore,
						dateBefore)) + 1;
				String queryString001 = "insert into tblsmart_contracts_new(EmailID,Duration_Data,Duration_Time,Status_U,O_Email_ID,O_File_Name,CurrentDate_U,CurrentTime_U,DayCount) values('"
						+ emailid
						+ "','"
						+ daycon
						+ "','"
						+ Duration_Time
						+ "','"
						+ status
						+ "','"
						+ O_Name
						+ "','"
						+ O_FileName
						+ "','"
						+ currentdate
						+ "','"
						+ currenttime
						+ "','"
						+ noOfDaysBetween + "')";
				st001.executeUpdate(queryString001);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		Statement st01;
		Statement st02;
		try {
			st01 = connection.createStatement();
			st02 = connection.createStatement();
			String ownername = (dbO_Name);
			String touser = (emailid);
			
			// String strss = "select * from tblmaster where ToName='" + touser
			// + "' and FromName='" + ownername + "'";
			System.out.println("UserName=>" + touser + "Owner Name=>"
					+ ownername + "FileName=>" + filename);
			ResultSet rss = st02
					.executeQuery("select * from tblmaster where ToName='"
							+ touser + "' and FromName='" + ownername
							+ "'and FileName='" + filename + "'");
			String action = "";
			int flag = 0;
			String data2 = ownername + filename + touser;
			// Block Chain Consensus
			ChainConsensus.Consensus(data2);
			Date timeStamp = new Date();
			String cdate = (String) timeStamp.toString();
			String Transcation_Hash = Block.hash;
			String FromName = ownername;
			String ToName = touser;
			String FileName = filename;
			String ActionData = "FileRequest";
			String FileTime = cdate;
			String DurationTime = daycon;
			String OwnerCost = dbownercost;
			String TransferCost = costtransfer;
			String NonceData = String.valueOf(Block.nonce);
			String PreViewHash = "0x";
			if (rss.next()) {
				action = rss.getString("ActionData");
				System.out.println(action);
				if (action.equals("FileShare")) {
					flag = 1;
				}

			} else {
				String queryStringmaster = "insert into tblmaster(Transcation_Hash,FromName,ToName,FileName,ActionData,FileTime,DurationTime,OwnerCost,TransferCost,NonceData,PreViewHash) values(?,?,?,?,?,?,?,?,?,?,?)";
				// conn4 =ConnectionFactory.getInstance().getConnection();
				ptmt = connection.prepareStatement(queryStringmaster);
				ptmt.setString(1, Transcation_Hash);
				ptmt.setString(2, FromName);
				ptmt.setString(3, ToName);
				ptmt.setString(4, FileName);
				ptmt.setString(5, ActionData);
				ptmt.setString(6, FileTime);
				ptmt.setString(7, DurationTime);
				ptmt.setString(8, OwnerCost);
				ptmt.setString(9, TransferCost);
				ptmt.setString(10, NonceData);
				ptmt.setString(11, PreViewHash);
				ptmt.executeUpdate();
			}
			if (flag == 1) {

				String queryString001 = "update tblmaster set DurationTime='"
						+ daycon + "',OwnerCost='" + dbownercost
						+ "',TransferCost='" + costtransfer
						+ "' where ToName='" + touser + "' and FromName='"
						+ ownername + "' and ActionData='" + action
						+ "' and FileName='" + filename + "'";
				st01.executeUpdate(queryString001);
			}
		} catch (SQLException e) {
			System.out.print(e);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Smart_Cont_Access.jsp");
		dispatcher.include(request, response);
	}

}
