<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<link  rel="stylesheet"  type="text/css" href="css/myApp.css">
<meta charset="ISO-8859-1">
<title>my first way in Struts</title>
</head>
<body>
<div style="margin: auto;">
<p style="font-size: 20">UPDATE PAGE</p>
<p><s:property value="username"/></p>
<h4>UPDATE YOUR YOUR INFORMATIONS</h4>

<s:form action="update" >
		<s:textfield  name="id" ></s:textfield>
		<s:textfield  name="nom" ></s:textfield>
		<s:textfield  name="poste" ></s:textfield>
		<s:textfield  name="fonction" ></s:textfield>
		<s:textfield  name="tel" ></s:textfield>
		
		<s:radio list="sexeRadio" name="sexe"></s:radio>
		<s:select list="ageselect" name="age"></s:select>
		
		
		<s:submit  name="modifier" value="modifier"></s:submit>
	</s:form>
</div>
</body>
</html>