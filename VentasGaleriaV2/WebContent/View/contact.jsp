<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Galeria AMP</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900"
	rel="stylesheet">


<link rel="stylesheet" href="../Resources/fonts/icomoon/style.css">
<link rel="stylesheet" href="../Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../Resources/css/Modal.css">


<link rel="stylesheet" href="../Resources/css/magnific-popup.css">
<link rel="stylesheet" href="../Resources/css/jquery-ui.css">
<link rel="stylesheet" href="../Resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="../Resources/css/owl.theme.default.min.css">

<link rel="stylesheet" href="../Resources/css/bootstrap-datepicker.css">

<link rel="stylesheet"
	href="../Resources/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="../Resources/css/aos.css">
<link rel="stylesheet" href="../Resources/css/fancybox.min.css">

<link rel="stylesheet" href="../Resources/css/style.css">

<link rel="stylesheet" href="../Resources/fileinput/fileinput.css">
<link rel="stylesheet" href="../Resources/css/SelectBox.css">

</head>
<body>

	<div id="app">

		<div class="site-wrap">

			<div class="site-mobile-menu">
				<div class="site-mobile-menu-header">
					<div class="site-mobile-menu-close mt-3">
						<span class="icon-close2 js-menu-toggle"></span>
					</div>
				</div>
				<div class="site-mobile-menu-body"></div>
			</div>

			<header class="header-bar d-flex d-lg-block align-items-center"
				data-aos="fade-left">
				<div class="site-logo">
					<a href="photos.jsp">Galeria</a>
				</div>

				<div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3"
					style="position: relative; top: 3px;">
					<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
						class="icon-menu h3"></span></a>
				</div>

				<div class="main-menu">
					<ul class="js-clone-nav">
	
						<li><a href="photos.jsp">Album</a></li>            
				        <li><a href="blog.jsp">Tendencias</a></li>
				        <li class="active"><a href="contact.jsp">Servicios</a></li>
				        <li><a href="bio.jsp">Motivacion</a></li>
					</ul>
					<ul class="social js-clone-nav">
						<li><a href="#"><span class="icon-facebook"></span></a></li>
						<li><a href="#"><span class="icon-twitter"></span></a></li>
						<li><a href="#"><span class="icon-instagram"></span></a></li>
					</ul>
				</div>
			</header>
			<main class="main-content">
				<div class="container-fluid photos">
					<div class="row justify-content-center">
						<div class="col-md-6 pt-4" data-aos="fade-up">
							<h2 class="text-white mb-4">Seleccione la Accion a Realizar</h2>

							<div class="row">
								<div class="col-md-12">
									<p class="mb-5">
										En este menu podra <a href="#">Agregar Album </a>, <a href="#">Modificar
											Album </a>, <a href="#">Modificar Foto </a>
									</p>
									<div class="row">
										<div class="col-md-12">
											<div class="row form-group">

												<div class="col-md-12 mb-12 mb-md-12">
													<div class="form-group">
														<label class="text-white" for="Accionfor">Acciones</label>
														<select class="form-control custom-select" id="Accionfor"
															v-on:change="CallForm()">
															<option value="0">--Seleccione--</option>
															<option value="1">Agregar Album</option>
															<option value="2">Modificar Album</option>
															<option value="3">Modificar Foto</option>
															<!--    <option v-for="(site,index) in sites" :key="index" :value="site.SITE_Id" :selected="site.SITE_Id == trabajadorSELECT.SITE_Id?'selected' : ''">{{site.SITE_Nombre}}-->
														</select>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>

					</div>

					<div class="row justify-content-center" v-show="Callfrm === '1'">
						<div class="col-md-6 pt-4" data-aos="fade-up">
							<h2 class="text-white mb-4">Agregar Categoria de la Foto</h2>

							<div class="row">
								<div class="col-md-12">
									<p class="mb-5">
										En este recuadro se podra agregar <a href="#">Las
											Categorias de las Fotos </a> asi como sus descripciones
										correspondientes
									</p>

									<div class="row">
										<div class="col-md-12">

											<div class="row form-group">
												<div class="col-md-12 mb-12 mb-md-12">
													<label class="text-white" for="titulo">Titulo</label> <input
														type="text" id=titulo name="titulo"
														v-model="Categoria.tituloA" class="form-control">
												</div>
												<div class="col-md-12">
													<label class="text-white" for="descripcion">Descripcion</label>
													<input type="text" id="descripcion" name="descripcion"
														v-model="Categoria.descripcionA" class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label class="text-white" for="urlFull">Nombre
														Imagen</label> <input type="text" id="urlFull" name="urlFull"
														class="form-control" v-model="Categoria.urlFullA">
												</div>
											</div>

											<div class="row form-group">
												<div class="col-md-12">
													<div class="form-group">
														<label class="text-white" for="foto">Foto</label>
														<div class="col-md-12">
															<input id="foto" name="foto" class="file" type="file">
														</div>
														<div class="col-md-12">
															<div id="errorBlock" class="help-block"></div>
														</div>
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<a class="btn btn-primary btn-md text-white"
															@click="AgregarCateogria()">Agregar Imagen</a>
													</div>


												</div>

											</div>

										</div>
									</div>
								</div>
							</div>

						</div>
					</div>

					<div class="row justify-content-center" v-show="Callfrm === '2'">
						<div class="col-md-6 pt-4" data-aos="fade-up">
							<h2 class="text-white mb-4">Modificar datos de Categoria de
								la Foto</h2>

							<div class="row">
								<div class="col-md-12">
									<div class="row form-group">

										<div class="col-md-12 mb-12 mb-md-12">
											<div class="form-group">
												<label class="text-white" for="catid">Listado de
													Categorias</label> <select class="form-control custom-select"
													id="catid" v-on:change="getDatabycat()">
													<option value="0">--Seleccione--</option>
													<option v-for="(cats,index) in Cat" :key="index"
														:value="cats.codigo">{{cats.descripcion}}</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="mb-5">
										En este recuadro se podra modificar <a href="#">Las
											Categorias de las Fotos </a> asi como sus descripciones
										correspondientes
									</p>

									<div class="row">
										<div class="col-md-12">										
											<div class="row form-group">
												<div class="col-md-12 mb-12 mb-md-12">
													<label class="text-white" for="titulo">Titulo</label> <input
														type="text" name="titulo" v-model="Categoria.Titulo"
														class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label class="text-white" for="descripcion">Descripcion</label>
													<input type="text" name="descripcion"
														v-model="Categoria.descripcion" class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label class="text-white" for="urlFull">Nombre
														Imagen</label> <input type="text" name="urlFull"
														class="form-control" v-model="Categoria.urlFull">
												</div>
											</div>

											<div class="row form-group">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input"
														id="checkbox" v-model="Categoria.checked"> <label
														for="checkbox" class="custom-control-label">Desea
														Agregar otra Imagen </label>
												</div>
											</div>

											<div class="row form-group" v-show="Categoria.checked">
												<div class="col-md-12">
													<div class="form-group">
														<label class="text-white" for="foto2">Foto</label>
														<div class="col-md-12">
															<input id="foto2" name="foto2" class="file" type="file">
														</div>
														<div class="col-md-12">
															<div id="errorBlock" class="help-block"></div>
														</div>
													</div>
												</div>
											</div>

											<div class="row form-group">
												<div class="col-md-12">
													<a class="btn btn-primary btn-md text-white"
														@click="ActualizarCategoria()">Actualizar Registro</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
										
					<div class="row justify-content-center" v-show="Callfrm === '3'">
						<div class="col-md-6 pt-4" data-aos="fade-up">
						<h2 class="text-white mb-4">Modificar Foto </h2>
							<div class="row">
								<div class="col-md-12">
									<div class="row form-group">
										<div class="col-md-12 mb-12 mb-md-12">
											<div class="form-group">
												<label class="text-white" for="fotogd">Listado de
													Fotos</label> <select class="form-control custom-select"
													id="fotogd" v-on:change="getDatabyPhoto()">
													<option value="0">--Seleccione--</option>
													<option v-for="(photos,index) in Photo" :key="index"
														:value="photos.codigo">{{photos.Titulo}}</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="mb-5">
										En este recuadro se podra modificar <a href="#">La
											 las Foto </a> asi como sus descripciones
										correspondientes
									</p>

									<div class="row">
										<div class="col-md-12">										
											<div class="row form-group">
												<div class="col-md-12 mb-12 mb-md-12">
													<label class="text-white" for="titulo">Titulo</label> <input
														type="text" name="titulo" v-model="ImgUpdate.Titulo"
														class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label class="text-white" for="descripcion">Descripcion</label>
													<input type="text" name="descripcion"
														v-model="ImgUpdate.descripcion" class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label class="text-white" for="urlFull">Nombre
														Imagen</label> <input type="text" name="urlFull"
														class="form-control" v-model="ImgUpdate.urlFull">
												</div>
											</div>

											<div class="row form-group">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input"
														id="liked" v-model="ImgUpdate.liked"> <label
														for="liked" class="custom-control-label">Desea
														Agregar otra Imagen </label>
												</div>
											</div>

											<div class="row form-group" v-show="ImgUpdate.liked">
												<div class="col-md-12">
													<div class="form-group">
														<label class="text-white" for="foto3">Foto</label>
														<div class="col-md-12">
															<input id="foto3" name="foto3" class="file" type="file">
														</div>
														<div class="col-md-12">
															<div id="errorBlock" class="help-block"></div>
														</div>
													</div>
												</div>
											</div>

											<div class="row form-group">
												<div class="col-md-12">
													<a class="btn btn-primary btn-md text-white"
														@click="ActualizarFoto()">Actualizar Registro</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>




					<div class="row justify-content-center">
						<div id="success_tic" class="modal fade" role="dialog"
							ref="success_tic">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<a class="close" href="#" data-dismiss="modal">&times;</a>
									<div class="page-body">
										<div class="head">
											<h3 style="margin-top: 5px;">Registro</h3>
											<h4>Se realizo la accion Correctamente</h4>
										</div>

										<h1 style="text-align: center;">
											<div class="checkmark-circle">
												<div class="background"></div>
												<div class="checkmark draw"></div>
											</div>
											<h1>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="row justify-content-center">
						<div class="col-md-12 text-center py-5">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								Todos los derechos Reservados| Desarrollado por by <a
									href="https://portalestudiante01.utp.edu.pe/" target="_blank">Alex
									Palli</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
					</div>
				</div>
			</main>

		</div>
		<!-- .site-wrap -->
	</div>
	<script src="../Resources/js/vue.js"></script>
	<script src="../Resources/js/axios.min.js"></script>
	<script src="../Resources/js/Categoria.js"></script>
	<script src="../Resources/js/jquery-3.3.1.min.js"></script>
	<script src="../Resources/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="../Resources/js/jquery-ui.js"></script>
	<script src="../Resources/js/popper.min.js"></script>
	<script src="../Resources/js/bootstrap.min.js"></script>
	<script src="../Resources/js/owl.carousel.min.js"></script>
	<script src="../Resources/js/jquery.stellar.min.js"></script>
	<script src="../Resources/js/jquery.countdown.min.js"></script>
	<script src="../Resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../Resources/js/bootstrap-datepicker.min.js"></script>
	<script src="../Resources/js/aos.js"></script>

	<script src="../Resources/js/jquery.fancybox.min.js"></script>

	<script src="../Resources/js/main.js"></script>
	<script src="../Resources/fileinput/fileinput.js"></script>

	<script>
		$("#foto").fileinput({
			'showCaption' : false, // The "1 file selected non-editable text field"
			'showRemove' : false, // The "Remove" button
			'showUpload' : false, // The "Upload" button
			'showBrowse' : true,
			'allowedFileExtensions' : [ 'jpg', 'png' ]
		});
		
		$("#foto2").fileinput({
			'showCaption' : false, // The "1 file selected non-editable text field"
			'showRemove' : false, // The "Remove" button
			'showUpload' : false, // The "Upload" button
			'showBrowse' : true,
			'allowedFileExtensions' : [ 'jpg', 'png' ]
		});
		
		$("#foto3").fileinput({
			'showCaption' : false, // The "1 file selected non-editable text field"
			'showRemove' : false, // The "Remove" button
			'showUpload' : false, // The "Upload" button
			'showBrowse' : true,
			'allowedFileExtensions' : [ 'jpg', 'png' ]
		});
	</script>



</body>
</html>