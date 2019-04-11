<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="_csrf" th:content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" th:content="${_csrf.headerName}"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Vos Comptes</title>

</head>
<body>
	<!-- header -->
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<img
					src="https://file.diplomeo-static.com/file/00/00/01/34/13486.svg"
					alt="" style="width: 50%">
			</div>
			<div style="margin-left: -20%;">
				<h1>UPHF Open Banking</h1>
			</div>
		</div>
	</div>

	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="welcome">Home<span
						class="sr-only">(current)</span></a>
					<form method="GET" action="getComptes" id="getComptes">
						<a href="#"
							onclick="document.getElementById('getComptes').submit();"
							class="nav-item nav-link">Comptes</a>
					</form>
					<form method="GET" action="getCompteToVirement" id="getCompteToVirement">
						<a href="#"
							onclick="document.getElementById('getCompteToVirement').submit();"
							class="nav-item nav-link">Virement</a>
					</form>
				</div>
			</div>
		</div>
	</nav>
	
	<!-- Corps de la page -->
	<div class="container">
		<div class="row" style="text-align: center;">
			<div class="col-md-6">
				<h1>${compte.libelle} </h1>
				<h2>${compte.commentaire }</h2>
			</div>
			<div class="col-md-6">
				<span class="badge badge-info" style="font-size: 30px; width: 100%;">Votre solde : <br>${compte.solde} Euros</span> 
			</div>
		</div>
		<hr>
		<h3>Historique des transactions</h3>
		<div class="table-responsive">
      	 	<table id="mytable" class="table table-bordred table-striped">
               <thead>
	                 <th style="text-align: center;">Libellé de la transaction</th>
	                 <th style="text-align: center;">Vers/De</th>
	                 <th style="text-align: center;">Montant</th>
               </thead> 
				<tbody>
  					<c:if test="${compte.virements != null }">
		  				<c:forEach var="virement" items="${compte.virements}">
						    <tr style="text-align: center;">
							    <td>${virement.libelle}</td>
							    <td>${virement.idCompteDestinataire}</td>
							    <td>${virement.montantVersement} Euros</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
		</div>
	</div>
	
	<!-- Footer -->
	<footer class="page-footer font-small blue">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			Authors : David Dupont & Guillaume Croy
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>
</html>