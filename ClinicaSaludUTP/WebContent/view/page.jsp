<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Clinica Salud UTP</title>
<meta name="description" content="Clinica Salud UTP">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="../images/Cli_logo.jpg">
<link rel="shortcut icon" href="../images/Cli_logo.jpg">

<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
<link rel="stylesheet" href="../resources/css/cs-skin-elastic.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/lib/chosen/chosen.min.css">

<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<div id="app">
		<!-- Left Panel -->

		<jsp:include page="menupage.jsp"></jsp:include>
		<!-- Left Panel -->


		<!-- Right Panel -->
		<div id="right-panel" class="right-panel">

			<!-- Header-->
			<jsp:include page="header.jsp"></jsp:include>
			<!-- Header-->
			<% String var = request.getParameter("view"); 
				int posicion;			
				posicion=var.indexOf("-");
				String folder=var.substring(0,posicion);
				var=folder+"/"+var+".jsp";
			%>
			<jsp:include page="<%=var%>"></jsp:include>

			<div class="clearfix"></div>

			<jsp:include page="footer.jsp"></jsp:include>


		</div>
		<!-- /#right-panel -->

		<!-- Right Panel -->

		<!-- Scripts -->
	</div>
	<script src="//cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
	<script
		src="//cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
	<script
		src="//cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
	<script
		src="//cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
	<script src="../resources/js/main.js"></script>
	<script src="../resources/js/lib/chosen/chosen.jquery.min.js"></script>
	<script src="../resources/js/vue.js"></script>
	<script src="../resources/js/axios.min.js"></script>
	<script src="../resources/js/especialidad.js"></script>

	<script>
		jQuery(document).ready(function() {
			jQuery(".standardSelect").chosen({
				disable_search_threshold : 10,
				no_results_text : "Oops, nothing found!",
				width : "100%"
			});
		});
	</script>

</body>
</html>