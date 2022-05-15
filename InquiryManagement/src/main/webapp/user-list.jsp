<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inquiry Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Inquiry
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Inquiry</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Inquiry</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Submit
					New Inquiry</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th> Code </th>
						<th> Customer ID </th>
						<th> Customer Name </th>
						<th> EleAccNo </th>
						<th> Address </th>
						<th> Contact </th>
						<th> Email </th>
						<th> Type </th>
						<th> Massage </th>
						<th> Status </th>
						<th> Password</th>
						<th>Actions</th>
					
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="inquiry" items="${listInquiry}">

						<tr>
							<td><c:out value="${Inqury.code}" /></td>
							<td><c:out value="${Inquiry.cusID}" /></td>
							<td><c:out value="${Inquiry.cusName}" /></td>
							<td><c:out value="${Inquiry.eleAccNo}" /></td>
							<td><c:out value="${Inquiry.address}" /></td>
							<td><c:out value="${Inquiry.email}" /></td>
							<td><c:out value="${Inquiry.contact}" /></td>
							<td><c:out value="${Inquiry.type}" /></td>
							<td><c:out value="${Inquiry.massage}" /></td>
							<td><c:out value="${Inquiry.status}" /></td>
							<td><c:out value="${Inquiry.password}" /></td>
							

							<td><a href="edit?code=<c:out value='${inquiry.code}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?code=<c:out value='${inquiry.code}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>