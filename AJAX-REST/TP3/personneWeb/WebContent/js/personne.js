var waySort;
var parameterSort;
var modal;

var sortByOneParameter = function(data, parameter, way) {
	var retour;
	console.log(way);
	console.log(parameter);
	way = way ? way : 'asc';
	parameter = parameter ? parameter : 'id';
	if (way && parameter) {
		retour = data.sort(function(a, b) {
			var compare;

			if (way == 'asc') {
				compare = a[parameter] > b[parameter] ? 1 : -1;
			} else if (way == 'desc') {
				compare = a[parameter] < b[parameter] ? 1 : -1;
			}
			return compare;
		});
	} else {
		retour = data
	}
	return retour
}

var getPersonnesData = function() {
	// recupération des donnée en desérialisant le storage
	var data = JSON.parse(localStorage.getItem('personnes'));
	var storageData = [];
	$.each(data, function(index, value) {
		// transaformation en date de la date qui est resté serialisé
		if (value.datenaiss) {
			value.datenaiss = new Date(Date.parse(value.datenaiss));
		}
		storageData.push(value);
	});
	return storageData;
}

var loadPersonnesData = function() {
	$.ajax({
		method : 'GET',
		url : 'http://localhost:8080/personneWeb/webapi/personneWebService',
		// parse de la réponse / choix du type si plusieurs dans réponse
		// contents : 'application/json',
		// type d'envoie
		contentType : 'application/json',
		dataType : 'json',
		context : $('#tablePersonne'),
	}).done(
			function(json) {
				var container = this;
				// variable locale qui permet de stoquer le json desérialisé
				var data = [];
				// console.log(json);
				$.each(json,
						function(index, value) {
							// la deserialisation ne créé pas de date
							if (value.datenaiss) {
								// transformation en date
								value.datenaiss = new Date(Date
										.parse(value.datenaiss));
							}
							// alimentation de la variable locale avec du 100%
							// objet
							data.push(value);
						});
				// stockage des objets dans le storage avec sérialisation des
				// objet
				// passage par objet et sérialisation : maintenabilité : la
				// deserialisation du json issue des service est decorrelé de la
				// gestion en websstorage
				localStorage.setItem('personnes', JSON.stringify(data));
				displayData(sortByOneParameter(getPersonnesData(),
						parameterSort, waySort));
			});
}

var displayData = function(data) {
	$('.tableBody').remove();
	$
			.each(
					data,
					function(index, value) {
						var row = '';
						row += '<div class="displayRow tableBody" data-id="'
								+ value.id + '">';
						row += '<div class="displayCell">' + value.nom
								+ '</div>';
						row += '<div class="displayCell">' + value.prenom
								+ '</div>';
						row += '<div class="displayCell">'
								+ $.datepicker.formatDate(
										$.datepicker.regional['fr'].dateFormat,
										value.datenaiss) + '</div>';
						row += '<div class="displayCell"><span class="buttonBody ui-icon ui-icon-closethick" data-id='
								+ value.id + '></span></div>';
						row += '</div>';
						$('#tablePersonne').append(row);
					})
	$(".tableBody").on(
			'click',
			function() {
				var id = $(this).attr('data-id')
				$('#personneForm').attr('data-id', id);
				var data = getPersonnesData();
				var personne;
				$.each(data, function(index, value) {
					var continueEach = true;
					if (value.id == id) {
						personne = value;
						continueEach = false;
					}
					return continueEach;
				});
				$('#inputPrenom').val(personne.prenom);
				$('#inputNom').val(personne.nom);
				$('#inputDateNaiss').val(
						$.datepicker.formatDate(
								$.datepicker.regional['fr'].dateFormat,
								personne.datenaiss));
				$('#update').show();
				$('#create').hide();
				modal.dialog('open');
			});
	$('.tableBody .buttonBody').button();
	$('.tableBody .buttonBody')
			.on(
					'click',
					function(event) {
						$
								.ajax(
										{
											method : 'DELETE',
											url : 'http://localhost:8080/personneWeb/webapi/personneWebService/'
													+ $(this).attr('data-id'),
											contents : 'application/json',
											context : $('#tablePersonne')
										}).done(function() {
									loadPersonnesData();
								});
						event.stopPropagation();
					});
}

var convertFormToObject = function() {
	personneDate = $.datepicker.parseDate(
			$.datepicker.regional['fr'].dateFormat, $('#inputDateNaiss').val())
	// datepicker applique affecte un GMT mais pas les minutes de déclage pour
	// compenser une date sans heure
	personneDate.setMinutes(personneDate.getMinutes()
			- personneDate.getTimezoneOffset())
	var personne = {
		'nom' : $('#inputNom').val(),
		'prenom' : $('#inputPrenom').val(),
		'datenaiss' : personneDate
	}
	return personne;
}

$()
		.ready(
				function() {
					console.log("jquery ready");
					// $.datepicker.setDefaults( $.datepicker.regional[ "fr" ]
					// );
					$('.headerButton span').button();
					modal = $('#modal').dialog({
						autoOpen : false,
						modal : true
					});
					$('#inputDateNaiss').datepicker();
					$('#update')
							.button()
							.on(
									'click',
									function() {

										$
												.ajax(
														{
															method : 'PUT',
															url : 'http://localhost:8080/personneWeb/webapi/personneWebService/'
																	+ $(
																			'#personneForm')
																			.attr(
																					'data-id'),
															// parse de la
															// réponse
															contents : 'application/json',
															// type d'envoie
															contentType : 'application/json',
															dataType : 'json',
															data : JSON
																	.stringify(convertFormToObject()),
															context : $('#tablePersonne'),
														}).done(function(json) {
													modal.dialog('close');
													loadPersonnesData();

												});
									})
					$('#create')
							.button()
							.on(
									'click',
									function() {

										$
												.ajax(
														{
															method : 'POST',
															url : 'http://localhost:8080/personneWeb/webapi/personneWebService',
															// parse de la
															// réponse
															contents : 'application/json',
															// type d'envoie
															contentType : 'application/json',
															dataType : 'json',
															data : JSON
																	.stringify(convertFormToObject()),
															context : $('#tablePersonne'),
														}).done(function(json) {
													modal.dialog('close');
													loadPersonnesData();

												});
									});

					$('#createForm').button().on('click', function() {
						$('#inputPrenom').val(null);
						$('#inputNom').val(null);
						$('#inputDateNaiss').val(null);
						$('#update').hide();
						$('#create').show();
						modal.dialog('open');
					});

					$('.headerButton span').on(
							'click',
							function() {
								waySort = $(this).attr('data-way');
								parameterSort = $(this).attr('data-field');
								displayData(sortByOneParameter(
										getPersonnesData(), parameterSort,
										waySort));
							});
					loadPersonnesData();

				});