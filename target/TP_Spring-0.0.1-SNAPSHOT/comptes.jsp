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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

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
		<c:if test="${comptes == null }">
			<span class="badge badge-danger">Vous n'avez pas encore de compte</span> 
		</c:if>	
		<div class="table-responsive">
      	 	<table id="mytable" class="table table-bordred table-striped">
               <thead>
	                 <th style="text-align: center;">Identifiant</th>
	                 <th style="text-align: center;">Compte</th>
	                 <th style="text-align: center;">Solde</th>
	                 <th style="text-align: center;">Détail</th>
	                 <th style="text-align: center;">Supprimer</th>
               </thead> 
				<tbody>
  					<c:if test="${comptes != null }">
		  				<c:forEach var="compte" items="${comptes}">
						    <tr style="text-align: center;">
							    <td>${compte.id}</td>
							    <td>${compte.libelle}</td>
							    <td>${compte.solde} Euros</td>
							    <td>
							    	<form action="getCompteById" method="GET">
						    			<input type="hidden" name="idCompte" value="${compte.id}" />
						    			<button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
						    		</form>
							    </td>
							    <td>
							    	<form action="deleteCompte" method="POST">
						    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						    			<input type="hidden" name="idCompte" value="${compte.id}" />
						    			<button type="submit" class="btn btn-danger"><i class="fas fa-close"></i></button>
						    		</form>
							    </td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<a class="btn btn-outlined btn-theme btn-lg" data-wow-delay="0.7s" style="width: 100%;" href="createCompte.jsp">Créer un compte</a>
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