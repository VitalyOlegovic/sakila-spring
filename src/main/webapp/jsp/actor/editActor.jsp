<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Edit actor</title>
</head>
<body>
	<h1>Edit actor</h1>
	<form:form id="form" method="post" modelAttribute="actor">
		<fieldset>
			<form:hidden path="actorId"/>
			<form:label path="firstName">First name</form:label>
			<form:input path="firstName"/>
			<form:label path="lastName">Last name</form:label>
			<form:input path="lastName"/>
			
		</fieldset>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>