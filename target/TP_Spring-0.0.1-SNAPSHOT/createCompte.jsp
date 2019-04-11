<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="_csrf" th:content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" th:content="${_csrf.headerName}" />
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

<title>Création de compte</title>

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
		<form role="form" id="createCompte" method="POST" action="createCompte">
	        <div class="form-group float-label-control">
	            <label for="">Libellé du compte</label>
	            <input name="libelle" type="text" class="form-control" placeholder="Libellé">
	        </div>
	        <div class="form-group float-label-control">
	            <label for="">Solde</label>
	            <input name="solde" type="number" step="0.01" class="form-control" placeholder="solde">
	        </div>
	        <div class="form-group float-label-control">
	            <label for="">Commentaire sur votre compte</label>
	            <textarea name="commentaire" class="form-control" placeholder="Commentaire" rows="1"></textarea>
	        </div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        <button type="submit" class="btn btn-outlined btn-theme btn-lg"
						data-wow-delay="0.7s" style="width: 100%;">Valider</button>
	    </form>
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