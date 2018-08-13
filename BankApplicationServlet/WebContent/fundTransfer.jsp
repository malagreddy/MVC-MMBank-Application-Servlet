<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<div class="navbar-fixed">
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>
<body>
<div class="container">
<form action="doFundTransfer.AppController" method="get">
	<div style="align-content: center">
		<table class="striped">
		<tr>
		<td>Enter Sender's Account number</td>
		<td><input type="text" name="accNoSender" required="required"></td>
		<td>Enter Recievers's Account number</td>
		<td><input type="text" name="accNoReciever" required="required"></td>
		<td>Enter Amount</td>
		<td><input type="text" name="amount" placeholder="0.0" required="required"></td>
		</tr>
		</table><br><br>
		<div class="center-align"><button class="btn waves-effect waves-light btn-large" type="submit" value="Deposit">Transfer Funds    <i class="material-icons right">send</i></button></div>
	</div>
</form>
</div>
</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>