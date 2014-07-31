<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.imie.model.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript">
	$().ready(function() {
		console.log('jquery ready');
		$('#addPersonneForm').button();
		$('#inputDateNaiss').datepicker();

	});
</script>
<form method="post" action="./NewPersonneControleur">
	<div>
		<div>
			<label>nom : </label><input type="text" name="nom" />
		</div>
		<div>
			<label>prenom :</label><input type="text" name="prenom" />
		</div>
		<div>
			<label>date de naissance : </label><input id="inputDateNaiss"
				type="text" name="dateNaiss" />
		</div>
	</div>
	<input id="addPersonneForm" type="submit" value="Créer personne" />
</form>
