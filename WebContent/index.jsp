<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<s:form action="welcome">
	<s:textfield name="username" label="username"/>
<s:submit value="valid" name="valid"></s:submit>
</s:form>

</body>
</html>