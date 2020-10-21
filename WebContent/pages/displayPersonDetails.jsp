<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display person details</title>
</head>
<body>

<table id="table-1" border="1">
	<thead>
		<tr>
			<th>Identifiant</th>
			<th>Age</th>
			<th>Sexe</th>
			<th>Nom</th>
			<th>Fonction</th>
			<th>Poste</th>
			<th>Telephone</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="nom"/></td>
			<td><s:property value="age"/></td>
			<td><s:property value="sexe"/></td>
			<td><s:property value="fonction"/></td>
			<td><s:property value="poste"/></td>
			<td><s:property value="tel"/></td>
			
			<td><s:url action="updateForm" var="urlTag">
			
				<s:param name="id"><s:property value="id"/> </s:param></s:url>
				<a href='<s:property value="#urlTag"/>'> modifier </a>
				<!-- delete -->
				<s:url action="delete" var="urlTag">
				<s:param name="id"><s:property value="id"/> </s:param></s:url>
				<a href='<s:property value="#urlTag"/>'> supprimer </a>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>