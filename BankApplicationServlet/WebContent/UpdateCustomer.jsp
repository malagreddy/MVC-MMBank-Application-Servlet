<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Details</title>
</head>
<div class="navbar-fixed">
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>
<body>
	<div class="container">
		<form method="get" action="updateAccount.AppController">
			<div style="align-content: center">
				<h1 class="center-align">Update Customer Details</h1>
				<table class="centered">
					<tr>
						<td>Customer ID:</td>
						<td><input type="text" name="customerid"
							value="${requestScope.account.accountHolder.customerId}" readonly></td>
						<td>Customer Name:</td>
						<td><input type="text" name="customerName"
							value="${requestScope.account.accountHolder.customerName}" required="required"></td>
						<td>Account Number:</td>

						<td><label>Browser Select</label><select
							class="browser-default" name="accNo">
								<option value="${requestScope.account.accountNumber}">${requestScope.account.accountNumber}</option>
						</select></td>
					</tr>
					<tr>
						<td>Mobile Number:</td>
						<td><input type="text" name="contactNumber"
							value="${requestScope.account.accountHolder.contactNumber}"
							pattern="^\d{10}" required="required"></td>
						<td>Email ID:</td>
						<td><input type="email" name="email"
							value="${requestScope.account.accountHolder.emailId}" required="required"></td>
						<td>Date of Birth:</td>
						<td><input type="date" name="dateOfBirth"
							value="${requestScope.account.accountHolder.dateOfBirth}" required="required"></td>
					</tr>
				</table><br><br>
				<div class="center-align">
					<button class="btn waves-effect waves-light btn-large"
						type="submit" value="Update Changes">
						Update Changes <i class="material-icons right">update</i>
					</button>
				</div>
			</div>
		</form>
	</div>

</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>