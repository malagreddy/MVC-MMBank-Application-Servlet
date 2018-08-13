<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a savings account</title>
</head>
<div>
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>
<body>
	<div>
		<h5 class="center-align">Enter Account Details</h5>
	</div>
	<div class="container">
		<form method="get" action="createCurrentAccount.AppController">
			<div align="center">
				<table >
					<tr>
						<td>Customer Name:</td>
						<td><input type="text" name="customerName"
							required="required"></td>
						<td>Mobile Number:</td>
						<td><input type="text" name="contactNumber" pattern="^\d{10}"
							required="required"></td>
					</tr>
					<tr>
						<td>Email ID:</td>
						<td><input type="email" name="email" required="required"></td>
						<td>Date of Birth:</td>
						<td><input type="date" name="dateOfBirth" required="required"></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" name="address" required="required"></td>
						<td>Nationality:</td>
						<td><input type="text" name="nationality" required="required"></td>
					</tr>
					<tr>
						<td>Gender</td>
						<td><label><input type="radio" class="with-gap"
								name="gender" value="Male" checked>Male</label></td>
						<td><label><input type="radio" class="with-gap"
								name="gender" value="Female">Female</h7></span></label></td>
						<td></td>
					</tr>
					<tr>
						<td>Enter overdraft limit</td>
						<td><input type="text" name="overdraft" required="required"></td>
					</tr>
					<tr>
						<td>Enter the initial balance<br>(Minimum Balance Rs.
							10,000.00)
						</td>
						<td><input type="text" name="balance" placeholder="Rs."
							required="required"></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="btn waves-effect waves-light btn-large"
								type="submit" value="Create Account">
								Create Current Account<i class="material-icons right">send</i>
							</button></td>
						<td><button class="btn waves-effect waves-light btn-large"
								type="reset" value="Reset Fields">
								Reset <i class="material-icons right">cancel</i>
							</button></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>