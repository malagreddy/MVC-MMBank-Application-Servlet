<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MoneyMoneyBankApplication</title>
</head>
<div>
	<nav>
		<jsp:include page="headers.jsp"></jsp:include>
	</nav>
</div>
<body>
	<div class="container">
		<table>
			<tr>
				<td><a href="addSavings.AppController">Create New Savings
						Account</a></td>

				<td><a href="addCurrent.AppController">Create New Current
						Account</a></td>
			</tr>

			<tr>
				<td><a href="viewAll.AppController">View All Accounts</a></td>

				<td><a href="viewCustomers.AppController">View All
						Customers</a></td>
			</tr>
			<tr>
				<td><a href="createSearch.AppController">SearchAccount</a></td>

				<td><a href="withdrawl.AppController">Withdraw amount from

				</td>
			</tr>

			<tr>
				<td><a href="deposit.AppController">Deposit amount to
						account</a></td>

				<td><a href="fundTransfer.AppController">Transfer Funds</a></td>
			</tr>

		</table>
	</div>
</body>
<jsp:include page="footers.jsp"></jsp:include>
</html>