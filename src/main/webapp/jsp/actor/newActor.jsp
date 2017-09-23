<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html  lang="it">
<head>
    <title>Create actor</title>
    <meta charset="UTF-8">
    <style>
    body {
        margin-left: 20%;
        margin-right: 20%;
        margin-top: 5%;
        margin-bottom: 5%;
    }
    section {
        display: block;
        margin-top: 10px;
        margin-bottom: 10px;
    }
    </style>
</head>
<body>
	<h1>Create actor</h1>
	<form:form id="form" method="post" modelAttribute="actor">
		<fieldset>
		    <section>
			<form:label path="firstName">First name</form:label>
			<form:input path="firstName"/>
			</section>
			<section>
			<form:label path="lastName">Last name</form:label>
			<form:input path="lastName"/>
			</section>
			<button type="submit">Submit</button>
			<button type="reset">Reset</button>
		</fieldset>

	</form:form>
</body>
</html>