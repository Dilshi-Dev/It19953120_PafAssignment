<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Inquiry Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Inquiry</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${inquiry != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${inquiry == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${inquiry != null}">
            			Edit Inquiry
            		</c:if>
						<c:if test="${inquiry == null}">
            			Add New Inquiry
            		</c:if>
					</h2>
				</caption>

				<c:if test="${inquiry != null}">
					<input type="hidden" name="code" value="<c:out value='${inquiry.code}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Customer ID</label> <input type="text"
						value="<c:out value='${inquiry.cusID}' />" class="form-control"
						name="cusID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${inquiry.cusNAme}' />" class="form-control"
						name="cusName">
				</fieldset>

				<fieldset class="form-group">
					<label>Eletricity Acc No</label> <input type="text"
						value="<c:out value='${inquiry.eleAccNo}' />" class="form-control"
						name="eleAccNo">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${inquiry.address}' />" class="form-control"
						name="address">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${inquiry.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Contact</label> <input type="text"
						value="<c:out value='${inquiry.contact}' />" class="form-control"
						name="contact">
				</fieldset>
				<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${inquiry.type}' />" class="form-control"
						name="type">
				</fieldset>
				<fieldset class="form-group">
					<label>Massage</label> <input type="text"
						value="<c:out value='${inquiry.massage}' />" class="form-control"
						name="massage">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Status</label> <input type="text"
						value="<c:out value='${inquiry.status}' />" class="form-control"
						name="status">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${inquiry.password}' />" class="form-control"
						name="password">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>