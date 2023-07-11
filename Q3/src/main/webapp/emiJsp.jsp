<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.text.DecimalFormat" import="java.math.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Calculator</title>
</head>
<body>
<%
double amt = Double.parseDouble(request.getParameter("amt"));
double interest = Double.parseDouble(request.getParameter("interest"));
int time = Integer.parseInt(request.getParameter("time"));

double rate = interest / 100 / 12;
double emi = (amt * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
double totalPayment = emi * time;



out.println("Principal Amount: " + amt + "<br>");
out.println("Interest Rate: " + interest + "%<br>");
out.println("Loan Tenure: " + time + " months<br>");
out.println("EMI: " + emi + "<br>");
out.println("Total Payment: " + totalPayment + "<br>");
%>
</body>
</html>