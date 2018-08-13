<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Account</title>
</head>
<div class="navbar-fixed">
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>
<body>
<div class="container">
<form action="search.AppController" method="get">
	<h1  class="center-align">Search Account</h1>
		<table class="centered">
			<tr>
			<td><b>Enter Account Number to be searched:</b></td>
				<td><input type="text" name="search" placeholder="Enter account Number" required="required"></td>
			</tr>
		</table><br><br>
		<div class="center-align">
		<button class="btn waves-effect waves-light btn-large"
						type="submit" value="Update Changes">
						Search Account <i class="material-icons right">search</i>
					</button></div>

		</form>
		</div>
</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>