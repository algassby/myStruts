<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  rel="stylesheet"  type="text/css" href="css/myApp.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
			<td id="id" class="id-<s:property value="id"/>" data-id="<s:property value="id"/>"><s:property value="id"/></td>
			<td id="nom" id = "nom" class="nom-<s:property value="id"/>" data-id="<s:property value="id"/>"><s:property value="nom"/></td>
			<td><s:property value="age"/></td>
			<td class="sexe" id="sexe-<s:property value="id"/>"><s:property value="sexe"/></td>
			<td><s:property value="fonction"/></td>
			<td><s:property value="poste"/></td>
			<td><s:property value="tel"/></td>
			
			<td><s:url action="updateForm" var="urlTag">
			
				<s:param name="id" ><s:property value="id"/> </s:param></s:url>
				<a class="btn btn-success" href='<s:property value="#urlTag"/>'> modifier </a>
				<!-- delete -->
				<%-- <s:url action="delete" var="urlTag">
				<s:param name="id"><s:property value="id"/> </s:param></s:url>
				<a onclick="getAjax()" href='<s:property value="#urlTag"/>'> supprimer </a>
				<a  href='<s:property value="#urlTag"/>'> supprimer </a> --%>
				<button class="btn btn-danger delete"  type="button">supprimer</button>
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
<div class="down">
	<display:table name="list" export="true" requestURI="" cellspacing="2" style="" >
	<display:column property="id" title="ID" sortable="true" media="excel"></display:column>
	<display:column property="nom" title="NOM" media="excel"></display:column>
	<display:column property="age" title="AGE" media="excel"></display:column>
	<display:column property="sexe" title="SEXE" media="excel"></display:column>
	<display:column property="fonction" title="FONCTION" media="excel"></display:column>
	<display:setProperty name="export.pdf" value="true" />
 	<display:setProperty name="export.excel" value="true" />
 	<display:setProperty name="export.csv" value="true" />
 	<display:setProperty name="export.xml" value="true" />
	</display:table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/myApp.js"></script>
</body>
</html>