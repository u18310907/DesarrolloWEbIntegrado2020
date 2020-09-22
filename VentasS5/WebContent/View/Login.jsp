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
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="../Resource/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../Resource/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition login-page">
	<div id="app">
		<div class="login-box">
			<div class="login-logo">
				<a href="Login.jsp"><b>Ventas</b>Online</a>
			</div>
			<!-- /.login-logo -->
			<div class="card">
				<div class="card-body login-card-body">
					<p class="login-box-msg">Iniciar Session</p>

					<div class="form">
						<div class="input-group mb-3">
							<input type="email" class="form-control" placeholder="Email" v-model="user.username">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-envelope"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="password" class="form-control"
								placeholder="Password" v-model="user.password">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-lock"></span>
								</div>
							</div>
						</div>
						<div class="row">
						
							<div class="col-6">
								<a href="RegistrarUsuario.jsp"type="submit" class="btn btn-info btn-block" >Registrarse</a>
							</div>
			
							<!-- /.col -->
							<div class="col-6">
								<button type="submit" class="btn btn-success btn-block"  @click="login">Login</button>
							</div>
							<!-- /.col -->
						</div>
					</div>

			
				</div>
				<!-- /.login-card-body -->
			</div>
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="../Resource/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../Resource/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../Resource/dist/js/adminlte.min.js"></script>
	<script src="../Resource/dist/js/vue.js"></script>
	<script src="../Resource/dist/js/axios.min.js"></script>
	<script type="text/javascript">		
	const app=new Vue({
		  el:'#app',
		  data:{ 
		    user:{
		    	username:'',
				password:''
		    },
		  },  methods:{
			  
			 
			  login:function(){
				 	var formdata=app.ToFormData(app.user);
				    const options = {
				                method: 'POST',		
				               // headers: { 'content-type': 'application/form-data' },
				                data: formdata,
				                url: "../Login",
				            };
				     axios(options)
				    .then(function(response){
				     console.log(response);
				    if(response.data[0]=="success"){location.replace(response.data[1])}
				
				    });
			
				  	
			  },
			  	    
			    ToFormData:function(obj){
			        var formdata = new FormData();
			        for(var key in obj){
			          formdata.append(key,obj[key]);
			        } 
			        return formdata;       
			    },
	
				 
		    },
		    
		    mounted:function(){   
		    }
		  })	  
</script>
</body>
</html>
