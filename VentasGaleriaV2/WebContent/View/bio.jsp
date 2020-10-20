<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Galeria AMP</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="../Resources/fonts/icomoon/style.css">

    <link rel="stylesheet" href="../Resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Resources/css/magnific-popup.css">
    <link rel="stylesheet" href="../Resources/css/jquery-ui.css">
    <link rel="stylesheet" href="../Resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../Resources/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="../Resources/css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="../Resources/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="../Resources/css/aos.css">
    <link rel="stylesheet" href="../Resources/css/fancybox.min.css">

    <link rel="stylesheet" href="../Resources/css/style.css">
    
  </head>
  <body>
  

  <div class="site-wrap">

  <div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
      <div class="site-mobile-menu-close mt-3">
        <span class="icon-close2 js-menu-toggle"></span>
      </div>
    </div>
    <div class="site-mobile-menu-body"></div>
  </div>

  <header class="header-bar d-flex d-lg-block align-items-center" data-aos="fade-left">
    <div class="site-logo">
      <a href="photo.jsp">Galeria</a>
    </div>
    
    <div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

    <div class="main-menu">
      <ul class="js-clone-nav">
    					<li><a href="photos.jsp">Album</a></li>            
				        <li><a href="blog.jsp">Tendencias</a></li>
				        <li><a href="contact.jsp">Servicios</a></li>
				        <li class="active"><a href="bio.jsp">Motivacion</a></li>
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
        
        <div class="col-md-6 pt-4">
          <figure class="mb-5" data-aos="fade-up">
            <img src="../Resources/images/About.jpg" alt="Image" class="img-fluid">
          </figure>

          <h2 class="text-white mb-4" data-aos="fade-up">Galeria de Fotos </h2>

          <div class="row" data-aos="fade-up">
            <div class="col-md-12">
              <p>Esta galeria fue implementada con <a href="#">Vue</a> para la carga asyncrona y mas rapida de los elementos, ademas por que tambien facilita el trabajo con las propiedades de cada uno de los elementos</p>
              <p>Tambien se uso <a href="#">Axios</a> & <a href="#">JQuery</a> para la transmision de datos entre el controlador y la vista, mas no obstante por restrincciones del template, se tuvo que hacer uso de javascript puro para la captura de datos</p>
              <p>Esta implementacion se realizo como trabajo para la PC2 del curso de Desarrollo Web Integrado </p>
 			  <p cass="mt-5">El lenguaje de programacion utilizado fue java, la base de datos utilizada fue Mysql y para las respuestas de datos se utilizo Gson .</p>
              <p cass="mt-4">Thanks! <br> Alex P.</p>
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

</div> <!-- .site-wrap -->

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
    
  </body>
</html>