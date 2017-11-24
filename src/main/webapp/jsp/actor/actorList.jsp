<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>Actor List</title>
    <meta charset="UTF-8">
    <style type = "text/css">
        body {
            margin-left: 10%;
            margin-top: 5%;
            margin-bottom: 5%;
        }
        table {
            width: 50%;
        }
        table, td, th, thead {
            border: 1px solid gray;
            border-collapse: collapse;
        }
        thead {
            font-weight: bold;
        }
        nav {
            margin-bottom: 10px
        }
        @media screen and (max-width: 900px) {
            body{
                margin-left: 10px;
                margin-top: 0px;
            }
            table{
                width: 100%;
            }
        }
    </style>
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
		<c:forEach var="actor" items="${lista}">
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