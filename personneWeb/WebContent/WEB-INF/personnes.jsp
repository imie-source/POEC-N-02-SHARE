<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.imie.model.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="./app.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./jquery-ui-1.10.4.custom/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js"></script>
<link href="./jquery-ui-1.10.4.custom/css/flick/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
$().ready(function(){
		console.log('jquery ready');
		$('#addPersonne').button()
		});
</script>
</head>
<body>
	<div class="table">
		<%
			List<Personne> personnes = (List<Personne>) session
					.getAttribute("personneList");
			SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
			for (Personne personne : personnes) {
		%>
		<div class="tableRow">
			<div class="tableCell">
				<%=personne.getNom()%>
			</div>
			<div class="tableCell">
				<%=personne.getPrenom()%>
			</div>
			<div class="tableCell">
				<%=spf.format(personne.getDateNaiss())%>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<a id="addPersonne" href="./NewPersonneControleur">Ajouter une personne</a>
</body>
</html>