<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>

	<h2>Spring Security Custom Login Form (XML)</h2>

	<div id="login-box">

		<h3>Login with Username and Password</h3>
<!--
		<c:if test="${2 > 0}">
			<h1>Invalid username/password.</h1>
		</c:if>
		<c:if test="${param.logout != null}">
			<c:out value="${param.logout}" /><h3>Logged out.</h3>
		</c:if>
-->
		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>

		  <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		  </table>
		</form>
	</div>

</body>
</html>