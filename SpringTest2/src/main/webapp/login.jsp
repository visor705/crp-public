<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>

	<h2>Spring Security Custom Login Form (XML)</h2>

	<div id="login-box">

		<h3>Login with Username and Password</h3>

		<c:if test="${param.error != null}">
			<p style="color:#ff0000">Invalid username/password.</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>Logged out.</p>
		</c:if>

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