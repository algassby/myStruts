<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  rel="stylesheet"  type="text/css" href="css/myApp.css">
<%-- <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script> --%>

<title>my first way in Struts</title>
</head>
<body>
<div id="entete">
	<p style="font-size: 20">HELLO</p>
	<p><s:property value="username"/></p>
	<h4>Liste des personnes</h4>
</div>
<div class = "corps">
<table id="table-1" border="1">
	<thead>
		<tr>
			<th>Identifiant</th>
			<th>Nom</th>
			<th>Age</th>
			<th>Sexe</th>
			<th>Fonction</th>
			<th>Poste</th>
			<th>Telephone</th>
			<th>Action</th>
		</tr>
	</thead>
	<s:iterator value="list">
	<tbody class="tbbody">
		<tr>
			<td id="id" ><s:property value="id"/></td>
			<td id="nom" id = "nom" class="nom-<s:property value="id"/>" data-id="<s:property value="id"/>"><s:property value="nom"/></td>
			<td><s:property value="age"/></td>
			<td class="sexe" id="sexe-<s:property value="id"/>"><s:property value="sexe"/></td>
			<td><s:property value="fonction"/></td>
			<td><s:property value="poste"/></td>
			<td><s:property value="tel"/></td>
			
			<td><s:url action="updateForm" var="urlTag">
			
				<s:param name="id" ><s:property value="id"/> </s:param></s:url>
				<a href='<s:property value="#urlTag"/>'> modifier </a>
				<!-- delete -->
				<s:url action="delete" var="urlTag">
				<s:param name="id"><s:property value="id"/> </s:param></s:url>
				<%-- <a onclick="getAjax()" href='<s:property value="#urlTag"/>'> supprimer </a> --%>
				<a  href='<s:property value="#urlTag"/>'> supprimer </a>
				<button class="delete" type="button">supprimer</button>
			</td>
		</tr>
	</tbody>
	</s:iterator>
	<s:form action="create" name="create">
		<s:textfield value="id" name="id" ></s:textfield>
		<s:textfield value="nom" name="nom" ></s:textfield>
		<s:textfield value="poste" name="poste" ></s:textfield>
		<s:textfield value="fonction" name="fonction" ></s:textfield>
		<s:textfield value="tel" name="tel" ></s:textfield>
		<s:radio list="sexeRadio"  name="sexe"></s:radio>
		<s:select list="ageselect" name="age"></s:select>
		
		<s:submit  name="ajouter" value="ajouter"></s:submit>
	</s:form>
</table>
<button class="btn" type="button">changer</button>
</div>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/myApp.js"></script>
</body>
</html>