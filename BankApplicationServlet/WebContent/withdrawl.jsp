<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdrawal</title>
</head>
<div class="navbar-fixed">
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>

<body>
	<div class="container">
		<form action="doWithdraw.AppController" method="get">

			<div style="align-content: center">
				<h1 class="center-align">Withdrawal</h1>
				<table class="striped">
					<tr>
						<td>Enter Account number</td>
						<td><input type="text" name="accNo" required="required"></td>
						<td>Enter Amount</td>
						<td><input type="number" min="0" name="amount"
							placeholder="0.0" required="required"></td>
					</tr>
				</table>
				<br> <br>
				<div class="center-align">
					<button class="btn waves-effect waves-light btn-large"
						type="submit" value="Deposit">
						Withdrawal <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>