<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="app">
<!-- <form method="post" action="/../../Semana5/UploadServlet" enctype="multipart/form-data"> -->
	<input type="text"  v-model="Usuario.prueba" value="example"/>
	<br>
	<input type="file" name="foto" id="foto"/>
	<br/><br/>
	<button type="submit"  @click="AgregarUsuario">Crear Usuario</button>
	
	  	

</div>
<script src="../Resource/dist/js/vue.js"></script>
<script src="../Resource/dist/js/axios.min.js"></script>
	<script type="text/javascript">		
	const app=new Vue({
		  el:'#app',
		  data:{ 
			    Usuario:{},
		  },  methods:{		
	
			  AgregarUsuario:function(){
				 	var formdata=app.ToFormData(app.Usuario);
				    const options = {
				                method: 'POST',	
				                //enctype : 'multipart/form-data',
				                data: formdata,
				                url: "../UploadServlet",
				            };
				     axios(options)
				    .then(function(response){
				    	console.log(response);   
				    });							  	
			  },
			  	    
			    ToFormData:function(obj){
			        var formdata = new FormData();
			       for(var key in obj){
			          formdata.append(key,obj[key]);   
			        } 
			      	 var imagefile = document.querySelector('#foto');
			          formdata.append("foto", imagefile.files[0]);
			        return formdata;       
			    },
			    
	
				 
		    },		    
		    mounted:function(){   
		    }
		  })	  
	</script>
</body>
</html>