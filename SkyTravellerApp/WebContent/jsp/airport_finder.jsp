<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travel Info</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script src="javascript/custom.js"> </script>
<link rel="Stylesheet" href="css/style.css" />
</head>
<body onload="getAirportData('Chicago');">
	<div class="wrapper">
		<div class="menu-bar">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Menu <span class="caret"></span>
				</button>
				<ul class="dropdown-menu dropdown-menu-right">
				<li><a href="./">Home</a></li>
					<!-- <li><a href="airport_finder.jsp">Airport Finder</a></li>
					<li><a href="travel_warning.jsp">Travel Warning</a></li>
					<li><a href="travel_news.jsp">Travel News</a></li> -->
					<%
						HttpSession sessions = request.getSession(false);
						if (sessions != null) {
							String userName = (String) sessions.getAttribute("TravelerId");
							if (userName != null) {
					%>
					<li><a href="history">View History</a></li>
					<li><a href="signout">Sign Out</a></li>
					<%
						}
						}
					%>



				</ul>
			</div>
		</div>
		<h2>Airport Finder</h2>
		<div class="trip-country-form">

			<label>Enter City:</label> <input type="text" value="Chicago"
				placeholder="Enter your City" onchange="getAirportData(this.value);"
				class="form-control" width="20%;" />
		</div>

		<table class="table table-bordered" id="airport-data"></table>
	</div>


</body>
</html>