<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
     <link rel="stylesheet" href="../Resources/fileinput/fileinput.css">

    
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

  <header class="header-bar d-flex d-lg-block align-items-center">
    <div class="site-logo">
      <a href="index.html">Shutter</a>
    </div>
    
    <div class="d-inline-block d-xl-none ml-md-0 ml-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

    <div class="main-menu">
      <ul class="js-clone-nav">
        <li><a href="index.jsp">Home</a></li>
        <li class="active"><a href="photos.html">Photos</a></li>
        <li><a href="bio.jsp">Bio</a></li>
        <li><a href="blog.jsp">Blog</a></li>
        <li><a href="contact.jsp">Contact</a></li>
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

      <div class="row pt-4 mb-5 text-center">
        <div class="col-12">
          <h2 class="text-white mb-4">'Nature' &mdash; 19 Photos</h2>
        </div>
      </div>

      <div class="row align-items-stretch" id="ImgSet">

      </div>
      
      <div class="row justify-content-center">
        
        <div class="col-md-6 pt-4"  data-aos="fade-up">
          <h2 class="text-white mb-4">Agregar Foto</h2>

          <div class="row">
            <div class="col-md-12">
              <p class="mb-5"> En este recuadro se podra agregar   <a href="#">Fotos </a>  asi como sus descripciones correspondientes</p>
              

              <div class="row">
                <div class="col-md-12">
                  <form  id="FormData" enctype="multipart/form-data"> 
                    <div class="row form-group">
                      <div class="col-md-12 mb-12 mb-md-12">
                        <label class="text-white" for="titulo">Titulo</label>
                        <input type="text" id=titulo name="titulo" class="form-control">
                      </div>
                      <div class="col-md-12">
                        <label class="text-white" for="descripcion">Descripcion</label>
                        <input type="text" id="descripcion" name="descripcion" class="form-control">
                      </div>
                    </div>
                    <div class="row form-group">
                      <div class="col-md-12">
                        <label class="text-white" for="urlFull">Nombre Imagen</label> 
                        <input type="text" id="urlFull" name="urlFull" class="form-control">
                      </div>
                    </div>
                    
                    <div class="row form-group">
                        <div class="col-md-12">
                                <div class="form-group">
                                  <label  class="text-white" for="foto">Foto</label>
                                  <div class="col-md-12">
                                        <input id="foto" name="foto" class="file" type="file" >
                                  </div>
                                  <div class="col-md-12">
                                    <div id="errorBlock" class="help-block"></div>
                                  </div>
                        </div>
                     </div>
                   </form>
                    <div class="row form-group">
                      <div class="col-md-6">
                      	<a class="btn btn-primary btn-md text-white" onclick="SendImg()">Agregar Imagen</a>
                      </div>
                      <div class="col-md-6">
                      	<a class="btn btn-success btn-md text-white" onclick="LoadingImg()">Actualizar Galeria</a>
                      	
                      </div>
                    </div>
                
                </div>
                
              </div>
            </div>
          </div>
        </div>

      </div>


      <div class="row justify-content-center">
        <div class="col-md-12 text-center py-5">
          <p>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
      </p>
        </div>
      </div>
    </div>
  </main>

</div> <!-- .site-wrap -->

</div>

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

  <script src="../Resources/js/Single.js"></script>
  

    
  </body>
</html>