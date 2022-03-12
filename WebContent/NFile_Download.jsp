<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@page import="Dao.*"%>
<%@ page import="Com.Connection.*"%>
<%@page import="Dao.user"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Block Chain</title>
<link rel="favicon" href="assets1/images/favicon.png">
<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="assets1/css/bootstrap.min.css">
<link rel="stylesheet" href="assets1/css/font-awesome.min.css">
<link rel="stylesheet" href="assets1/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="assets1/css/da-slider.css" />
<link rel="stylesheet" href="assets1/css/style.css">
<script src="assets1/js/html5shiv.js"></script>
<script src="assets1/js/respond.min.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse" style="background-color: black;">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Index.jsp">
					<h4>Block Chain</h4>
				</a>
			</div>
			<%
				Connection connection = ConnectionFactory.getInstance()
						.getConnection();
				String uemail = (String) session.getAttribute("U_Email_ID");
				String queryString01 = "select * FROM tblusername WHERE Email_ID='"
						+ uemail + "'";
				PreparedStatement ptmt01 = connection
						.prepareStatement(queryString01);
				String costdb = "";
				ResultSet resultSet01 = ptmt01.executeQuery();
				if (resultSet01.next()) {
					costdb = resultSet01.getString("Cost_Data");
				}
			%>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">

					<li class="active"><a href="UserHomePage.jsp">Home</a></li>
					<li><a href="All_U_Request_File.jsp">All File</a></li>
					<li><a href="All_U_Share_File.jsp">Share File</a></li>
					<li><a href="Smart_Cont_Access.jsp">File Access</a></li>

					<li class="dropdown"><a href="LoginPage" class="dropdown-toggle"
						data-toggle="dropdown"><label style="color: white;"><%=session.getAttribute("U_Name")%></label><b
							class="caret"></b></a>

						<ul class="dropdown-menu">
							<li><a href="LoginPage"><label style="color: white;">Logout</label></a></li>
							<li><a href="LoginPage"><label style="color: white;">Account
										Balance: <%=costdb%></label></a></li>

							<!-- <li><a href="#">Dropdown Link 1</a></li>
                            <li class="active"><a href="#">Dropdown Link 2</a></li> -->


						</ul></li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->

	<!-- Header -->
	<header id="headO2">
		<div class="container">
			<div class="banner-content">
				<%
					String key = request.getParameter("key");
					if (key == null) {
			
						String datainfo = request.getParameter("name");
						String[] infodata = datainfo.split(",");
						String O_FileName = infodata[2].toString();

						String ownername = infodata[1].toString();
						String emailid = (String) session.getAttribute("U_Email_ID");
						//String key=request.getParameter("key");
						System.out.println("UserEmail=>" + emailid + "\t Owner Email=>"
								+ ownername + "\t FileName=>" + O_FileName);

						Connection con1 = ConnectionFactory.getInstance()
								.getConnection();
						Statement st01 = con1.createStatement();
						ResultSet rs001 = st01
								.executeQuery("select * from filerequest  where username='"
										+ emailid
										+ "'and Ownername='"
										+ ownername
										+ "' and Filename='"
										+ O_FileName
										+ "' and Status='Request Accept' ");
						if (rs001.next()) {
							System.out.println("NFile If");
				%>
			</div>
		</div>
	</header>
	<!-- /Header -->


	<div id="courses"></div>
	<!-- container -->
	<section class="container">
		<br>
		<div class="row">
			<div class="col-md-4">
				<img src="./images/login.jpg" alt="" class="img-responsive">
			</div>
			<%
			int timeflag=0;
				Connection con = ConnectionFactory.getInstance()
								.getConnection();
						String day = request.getParameter("day");
						Statement st1 = con.createStatement();
						int flag = 0;
						ResultSet rs01 = st1
								.executeQuery("select * from tblsmart_contracts_new where EmailID='"
										+ emailid
										+ "' and O_File_Name='"
										+ O_FileName
										+ "' and O_Email_ID='"
										+ ownername + "'");
						if (rs01.next()) {
							day = rs01.getString("Duration_Data");
							flag = 1;
						}
						if (flag == 1) {
							if (day.equals("5#Min")) {
								timeflag=TimeLookup.timer5min(emailid, O_FileName, day);
							} else if (day.equals("10#Min")) {
								timeflag=TimeLookup.timer10min(emailid, O_FileName, day);
							} else if (day.equals("15#Min")) {
								timeflag=TimeLookup.timer15min(emailid, O_FileName, day);
							} else if (day.equals("20#Min")) {

								timeflag=TimeLookup.timer20min(emailid, O_FileName, day);
							} else if (day.equals("30#Min")) {
								timeflag=TimeLookup.timer30min(emailid, O_FileName, day);
							}
							System.out.println("Smart Contract Expiry"+timeflag);
							if(timeflag==0)
							{
			%>
			<div class="col-md-8">
				<div>
					<div>
						<div class="panel panel-primary">
							<div class="panel-heading" align="center">File Download
								Page</div>
							<div class="panel-body">
								<form class="form-light mt-20" action="File_Download"
									method="post" autocomplete="off">
									<div class="form-group">
										<input type="text" class="form-control" name="ownername"
											value="<%=ownername%>" readonly="readonly"> <br>
										<input type="text" class="form-control" name="name"
											value="<%=O_FileName%>" readonly="readonly"> <br>
										<input type="text" class="form-control" name="attribute_1"
											placeholder="Enter File Name" required> 

										<!-- <select class="form-control" name="attribute_5">
            <option value="a">Select Gender</option>
  <option value="Male">Male</option>
  <option value="Female">Female</option>  
</select>  -->
									</div>
									<input type="submit" value="Download" class="btn btn-success">
									<input type="reset" class="btn btn-danger"><br /> <br />
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
	<%}
							else
							{
								%>
								<script type="text/javascript">
									alert("Smart Contract Expiry");
								</script>
								<%	
								
							}
		} else {
					System.out.println("Smart");
	%>
	<script type="text/javascript">
		alert("Please do smart contract first");
	</script>
	<%
		response.sendRedirect("Smart_Cont_Access.jsp?key=2");
				}
			}

			else {
				System.out.println("Smart");
	%>
	<script type="text/javascript">
		alert("Please do smart contract first");
	</script>
	<%
		response.sendRedirect("Smart_Cont_Access.jsp?key=2");
			}
					} else if (key.equals("1")) {
						%>


		<script type="text/javascript">
					
					alert("Wrong Attribute Please try again");		</script>


						<%
							//response.sendRedirect("File_Downloads.jsp");

							} 
	%>
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="assets1/js/modernizr-latest.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets1/js/jquery.cslider.js"></script>
	<script src="assets1/js/custom.js"></script>
</body>
</html>