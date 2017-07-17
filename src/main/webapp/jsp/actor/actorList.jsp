<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>Actor List</title>
    <meta charset="UTF-8">
</head>
<body>
	<h1>Actor List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Last Update</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="actor" items="${list}">
			<tr>
				<td>${actor.actorId}</td>
				<td>${actor.firstName}</td>
				<td>${actor.lastName}</td>
				<td>${actor.lastUpdate}</td>
				<td><a href="editActor/${actor.actorId}">Edit</a></td>
				<td><a href="deleteActor/${actor.actorId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>