package com.moneymoney.app.web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moneymoney.app.model.service.MMBankAccountService;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.service.BankAccountService;

@WebServlet("*.AppController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppController() {
	}

	BankAccountService service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		service = new MMBankAccountService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			switch (action) {

			case "/addSavings.AppController":// redirects to the savings account page
				response.sendRedirect("NewSavingsAccountsDetails.jsp");
				break;

			case "/createSavingsAccount.AppController":// creates a new savings account with the help of a helper
														// function
				createSavingsAccount(request, response);
				request.setAttribute("message", "Savings Account successfully created with account number "
						+ Integer.toString(service.getNextAccountNumber() - 1));
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
				break;

			case "/viewAll.AppController":// forwards to the view all page
				request.setAttribute("allAccount", service.getAllAccounts());
				request.getRequestDispatcher("viewAll.jsp").forward(request, response);
				break;

			case "/addCurrent.AppController":// redirects to the current account page
				response.sendRedirect("NewCurrentAccountsDetails.jsp");
				break;

			case "/createCurrentAccount.AppController":// creates a new savings account with the help of a helper
														// function
				createNewCurrentAccount(request, response);
				// dispatch a customized message to a message page here
				request.setAttribute("message", "Current Account successfully created with account number "
						+ Integer.toString(service.getNextAccountNumber() - 1));
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
				break;

			case "/createSearch.AppController":// redirects to the search account page
				response.sendRedirect("searchAccount.jsp");
				break;

			case "/search.AppController":// searches the account with given account id
				doSearch(request, response);
				break;

			case "/viewCustomers.AppController":// redirects to the viewall customers page
				service.getAllAccounts().stream()
						.forEach((elemnt) -> System.out.println(elemnt.getAccountHolder().getEmailId()));
				request.setAttribute("allAccount", service.getAllAccounts());
				request.getRequestDispatcher("viewAllCustomers.jsp").forward(request, response);
				break;

			case "/editform.AppController":// forwards to the update customer page

				request.setAttribute("account",
						service.getAccountById(Integer.parseInt(request.getParameter("accountNo"))));

				request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
				break;

			case "/updateAccount.AppController":// updates a customer's details with help of helper methods
				updateCustomer(request);
				// redirection to a message page
				System.out.println("Updated");
				break;
			case "/withdrawl.AppController":// redirects to the withdrawal page
				response.sendRedirect("withdrawl.jsp");
				break;
			case "/doWithdraw.AppController":// makes a withdrawal with help of helper methods
				withdraw(request, response);
				break;

			case "/deposit.AppController":// redirects to the deposit page
				response.sendRedirect("deposit.jsp");
				break;
			case "/doDeposit.AppController":// makes a deposit with help of helper methods
				deposit(request, response);
				break;
			case "/fundTransfer.AppController":// redirects to the fund transfer page
				response.sendRedirect("fundTransfer.jsp");
				break;
			case "/doFundTransfer.AppController":// performs fund transfer between two account with the help of helper
													// methods
				doFundtransfer(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Oops!! Something went wrong. Please check your query string.Maybe you have entered an invalid account number");
			request.getRequestDispatcher("messagePage.jsp").forward(request, response);
		}
//			finally {
//			request.setAttribute("message", "Something went wrong. Please check your query string");
//			request.getRequestDispatcher("messagePage.jsp").forward(request, response);
//		}

	}

	// helper method to transfer funds
	private void doFundtransfer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int status = service.fundTransfer(Integer.parseInt(request.getParameter("accNoSender")),
				Integer.parseInt(request.getParameter("accNoReciever")),
				Double.parseDouble(request.getParameter("amount")));
		String message = "Fund transfer unsuccessful due to insufficient funds in the senders account";
		if (status != -1) {
			message = "<h2>Fund Transfer was successful</h2> Date and time of transfer is "
					+ (LocalDate.now()).toString();
			System.out.println(LocalDate.now());
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("messagePage.jsp").forward(request, response);
	}

	// performs deposit
	private void deposit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service.getAccountById(Integer.parseInt(request.getParameter("accNo")))
				.deposit(Double.parseDouble(request.getParameter("amount")));
		String message = "<h2>Transaction Successful.</h2><br>Account balance after Deposit : Rs "
				+ service.getCurrrentBalance(service.getAccountById(Integer.parseInt(request.getParameter("accNo"))));
		request.setAttribute("message", message);
		request.getRequestDispatcher("messagePage.jsp").forward(request, response);
	}

	// helper method to perform withdraw
	private void withdraw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (service.withdraw(Integer.parseInt(request.getParameter("accNo")),
				Double.parseDouble(request.getParameter("amount"))) == -1) {
			request.setAttribute("message", "Transaction Unsuccessful due to insufficient funds");
			request.getRequestDispatcher("messagePage.jsp").forward(request, response);

		} else {
			double amount = Double.parseDouble(request.getParameter("amount"));
			Map<Integer, Integer> denomination = new HashMap<>();
			int ar[] = { 2000, 500, 200, 100, 50, 20, 5, 2, 1 };
			int i = 0;
			for (i = 0; i < 9; i++)
				denomination.put(ar[i], 0);
			for (i = 0; i < 9; i++) {
				denomination.put(ar[i], (int) amount / ar[i]);
				amount = amount % ar[i];
			}

			int totalNotes = 0;
			for (i = 0; i < 9; i++)
				totalNotes += denomination.get(ar[i]);

			String message = "<h3>Transaction Successful</h3><br><h3>Total no. of notes: " + totalNotes + "</h3>";
			for (i = 0; i < 9; i++) {
				if (denomination.get(ar[i]) > 0)
					message = message + "<h5>Denomination " + ar[i] + " : " + denomination.get(ar[i]) + "</h5>";
			}
			request.setAttribute("message", message);
//			System.out.println(request.getAttribute("message"));
			request.getRequestDispatcher("messagePage.jsp").forward(request, response);
		}

	}

	// helper method to update customer details
	private void updateCustomer(HttpServletRequest request) {

		service.getAccountById(Integer.parseInt(request.getParameter("accNo"))).getAccountHolder()
				.setCustomerName(request.getParameter("customerName"));
		service.getAccountById(Integer.parseInt(request.getParameter("accNo"))).getAccountHolder()
				.setEmailId(request.getParameter("email"));
		service.getAccountById(Integer.parseInt(request.getParameter("accNo"))).getAccountHolder()
				.setContactNumber(Long.parseLong(request.getParameter("contactNumber")));
		service.getAccountById(Integer.parseInt(request.getParameter("accNo"))).getAccountHolder().setDateOfBirth(
				LocalDate.parse(request.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

	}

	// helper method to search accounts
	private void doSearch(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BankAccount account = service.getAccountById(Integer.parseInt(request.getParameter("search")));
		if(account==null)throw new Exception();
		Collection<BankAccount> allAccount = new ArrayList<>();
		allAccount.add(account);
		request.setAttribute("allAccount", allAccount);
		request.getRequestDispatcher("viewAll.jsp").forward(request, response);
		// request.getRequestDispatcher("dummy.jsp").forward(request, response);

	}

	// helper method to create a new current account
	private void createNewCurrentAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("accountHolderName", request.getParameter("customerName"));
		map.put("contactNo", Long.parseLong(request.getParameter("contactNumber")));
		map.put("email", request.getParameter("email"));
		map.put("dateOfBirth",
				LocalDate.parse(request.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		map.put("address", request.getParameter("address"));
		map.put("nationality", request.getParameter("nationality"));
		map.put("gender", request.getParameter("gender"));
		map.put("overdraft", Double.parseDouble(request.getParameter("overdraft")));
		map.put("accountBalance", Double.parseDouble(request.getParameter("balance")));
		// System.out.println("L2");
		// dob check
		boolean isDob = dobCheck((LocalDate) map.get("dateOfBirth"));
		boolean check = ((double) map.get("accountBalance") >= 10000.0) ? true : false;
		if (isDob && check) {
			service.createNewCurrentAccount(map);
		} else {
			if (!isDob) {
				request.setAttribute("message", "You must be above 18 years of age to bank with us. Sorry!");
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
			} else {
				request.setAttribute("message",
						"Minimum balance of Rs.10,000.00 is required to open a Current account!! Sorry");
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
			}
		}
	}

	// helper method to create a new savings account
	private void createSavingsAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("accountHolderName", request.getParameter("customerName"));
		map.put("contactNo", Long.parseLong(request.getParameter("contactNumber")));
		map.put("email", request.getParameter("email"));
		map.put("dateOfBirth",
				LocalDate.parse(request.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		map.put("address", request.getParameter("address"));
		map.put("nationality", request.getParameter("nationality"));
		map.put("gender", request.getParameter("gender"));
		map.put("salary", Boolean.parseBoolean(request.getParameter("salaried")));
		map.put("accountBalance", Double.parseDouble(request.getParameter("balance")));
		// System.out.println("L1");
		// dob check
		boolean isDob = dobCheck((LocalDate) map.get("dateOfBirth"));
		boolean check = (((boolean) map.get("salary") && (double) map.get("accountBalance") >= 0.0)
				|| (!(boolean) map.get("salary") && (double) map.get("accountBalance") >= 5000.0)) ? true : false;

		if (isDob && check) {
			service.createNewSavingsAccount(map);
		} else {
			if (!isDob) {
				request.setAttribute("message", "You must be above 18 years of age to bank with us. Sorry!");
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
			} else {
				request.setAttribute("message",
						"Minimum balance of Rs.5000.00 is required to open a Savings account!! Sorry");
				request.getRequestDispatcher("messagePage.jsp").forward(request, response);
			}
		}
	}

	// helper method that returns if the date passed in the parameter is above 18yrs
	private boolean dobCheck(LocalDate date) {
		LocalDate now = LocalDate.now();
		return (now.getYear() - date.getYear() >= 18) ? true : false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
