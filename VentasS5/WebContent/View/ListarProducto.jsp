<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Ventas Online</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="../Resource/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="../Resource/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="../Resource/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../Resource/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div id="app">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
						href="#" role="button"><i class="fas fa-bars"></i></a></li>
					<li class="nav-item d-none d-sm-inline-block"><a href="#"
						class="nav-link">Home</a></li>
					<li class="nav-item d-none d-sm-inline-block"><a href="ListarProducto.jsp" type="submit"
						class="nav-link">Productos</a></li>
				</ul>

	

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="fa fa-cog"></i> <span
						class="badge badge-warning navbar-badge"></span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-item dropdown-header">
							Configuraciones</span>
						<div class="dropdown-divider"></div>
						<a href="Perfil.jsp" type="submit" class="dropdown-item"> <i
							class="fas fa-users mr-2"></i> Perfil
						</a>
						<div class="dropdown-divider"></div>
						<button  @click="Logout" class="dropdown-item"> <i
							class="fa fa-arrow-circle-right mr-2"></i> Cerrar Session
						</button>
					</div></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="#" class="brand-link"> <img src="../Imagenes/vo2.jpg"
				alt="Ventas Online" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Ventas Online</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img :src="UserVista.ruta"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">{{ImageVista.user}}</a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fa fa-clipboard"></i>
								<p>
									Categoria <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="AgregarCategoria.jsp" type="submit" class="nav-link"> <i
										class="fa fa-plus-circle mr-1"></i>
										<p>Agregar Categoria</p>
								</a></li>
								</a></li>
					</ul>
					</li>

					<li class="nav-item has-treeview "><a href="#"
						class="nav-link "> <i class="nav-icon fa fa-shopping-basket"></i>
							<p>
								Producto <i class="right fas fa-angle-left"></i>
							</p>
					</a>
						<ul class="nav nav-treeview ">
							<li class="nav-item "><a href="ResgitrarProducto.jsp"  type="submit" class="nav-link "> <i
									class="fa fa-plus-circle mr-1"></i>
									<p>Agregar Producto</p>
							</a></li>
						</ul></li>

					<li class="nav-item has-treeview menu-open"><a href="#" class="nav-link active">
							<i class="nav-icon fa fa-shopping-basket"></i>
							<p>
								Listar Productos <i class="right fas fa-angle-left"></i>
							</p>
					</a>
						<ul class="nav nav-treeview">
						<li class="nav-item"><a href="../View/ListarProducto.jsp?c=carnes" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Carnes</p>
							</a></li>
							<li class="nav-item"><a href="../View/ListarProducto.jsp?c=frutas" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Frutas</p>
							</a></li>
							<li class="nav-item"><a href="../View/ListarProducto.jsp?c=verduras" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Verduras</p>
							</a></li>
							<li class="nav-item"><a href="../View/ListarProducto.jsp?c=dulces" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Dulces</p>
							</a></li>
								<li class="nav-item"><a href="../View/ListarProducto.jsp?c=lacteos" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Lacteos</p>
							</a></li>
							<li class="nav-item"><a href="../View/ListarProducto.jsp?c=Pan" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Pan</p>
							</a></li>
						</ul></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6 offset-md-1">
							<h1>Listado de Productos </h1>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->

						<div class="col-md-10 offset-md-1">
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Carnes</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<div class="form" role="form">
									<div class="card-body">
											 <table id="TableListaProductos" class="table table-striped table-bordered table-hover" >
									            <thead>
									              <tr>
									                <th>Nombre</th>
									                <th>Descripcion</th>
									                <th>Proveedor</th>
									                <th>Unidad</th>
									                <th>Precio</th>
									                <th>Observaciones</th>
									              </tr>
									            </thead>
									            <tbody>
									         
									            </tbody>
									          </table>
									</div>
									<!-- /.card-body -->						
								</div>
							</div>
							<!-- /.card -->
						</div>

					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Alex Palli</b> U18310907
			</div>
			<strong>Copyright &copy; 2020
			</strong> 
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="../Resource/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../Resource/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
		src="../Resource/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../Resource/dist/js/adminlte.min.js"></script>

	<script src="../Resource/dist/js/vue.js"></script>
	<script src="../Resource/dist/js/axios.min.js"></script>
	
	<script src="../Resource/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="../Resource/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script src="../Resource/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script src="../Resource/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="../Resource/dist/js/demo.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			bsCustomFileInput.init();
	
		});
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		//const get = urlParams.get('c');
		//= urlParams.get('c')
		const c =urlParams.get('c');
		//if(urlParams.get('c')){
		
			//const c =urlParams.get('c');
		//}
		//else{
			//const c ="main";
		//}
		//const info=c;
	</script>
		<script type="text/javascript">
		
		  
		const app=new Vue({
	
			  el:'#app',
			  data:{ 
				  Productos:[],
				  UserVista:[
						ruta='',
				  ],
				  ImageVista:[
						img='',
				  ],
				  dataTable:null,
			  },  methods:{
				  Logout:function(){
					    const options = {
					                method: 'POST',		
					                url: "../Logut",
					            };
					     axios(options)
					    .then(function(response){
					     console.log(response);
					    if(response.data[0]=="success"){location.replace(response.data[1])}				
					    });							  	
				  },
				  
				  ValidarSessiones:function(){
					    const options = {
					                method: 'POST',		
					                url: "../ValidarSession",
					            };
					     axios(options)
					    .then(function(response){
					     console.log(response);
					    if(response.data[0]=="Redirect"){location.replace(response.data[1])}				
					    });							  	
				  },
				  
				  VistaImagen:function(){
					    const options = {
					                method: 'POST',		
					                url: "../UserUrl",
					            };
					     axios(options)
					    .then(function(response){
					     console.log(response);
					        app.ImageVista=response.data[0];   
					        app.UserVista=response.data[1];  
					        app.UserVista.ruta=app.UserVista.imgurl+app.ImageVista.img;			
					    });							  	
				  },
				  
				  	    
				    ToFormData:function(obj){
				        var formdata = new FormData();
				        for(var key in obj){
				          formdata.append(key,obj[key]);
				        } 
				        return formdata;       
				    },
				    
					  TableProductos:function(datos){ 
					      const options = {
					                  method: 'POST',	
					                  data: 'c='+c,
					                  url: "../ListarProducto",
					              };
					     axios(options)
					    .then(function(response){
					      console.log(response);
					      app.Productos=response.data;   	
					      
					    
					      $(app.Productos).each(function(i, dtl) {
					    	  datos.row.add([
					    		  dtl.nombre,
					    		  dtl.descripcion,
					    		  dtl.proveedor,
					    		  dtl.unidad,
					    		  dtl.precio,
					    		  dtl.observaciones,
					    		  ]).draw(false)
			                });
					      				      					      					      					      
					      });
					  },
		
					 
			    },
			    
			    mounted:function(){   	
			    		this.ValidarSessiones();
			    	 	this.VistaImagen();
				        datos = $('#TableListaProductos').DataTable({
				           responsive: true
				        });
				        this.TableProductos(datos);		
				   
			    }
			  })
		  	
		

	  
</script>
</body>
</html>

