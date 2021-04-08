const app=new Vue({
		  el:'#app',
		  data:{ 
			    Rol:[],
 				RolList:[],
				showModal: false
		  },  methods:{		
			  RegistrarEspecialidad:function(){
				var formdata=app.ToFormData(app.Rol);
				formdata.append('action','Registrar');
				    const options = {
				                method: 'POST',	
				                url: "../EspecialidadController",
								data: formdata,
				            };
				     axios(options)
				    .then(function(response){
						app.showModal=true;
				      	let modalSetTimeout = null; 
						modalSetTimeout = setTimeout(() => {
						        app.showModal=false
						      }, 1000);
				    	console.log(response);   
							
				    });							  	
			  },
	
	  		ActualizarEspecialidad:function(){
				var formdata=app.ToFormData(app.Rol);
				var codigo =event.target.value;
				formdata.append('action','Actualizar');
				formdata.append('cod_Rol',codigo);
				
				    const options = {
				                method: 'POST',	
				                url: "../EspecialidadController",
								data: formdata,
				            };
				     axios(options)
				    .then(function(response){
						app.showModal=true;
				      	let modalSetTimeout = null; 
						modalSetTimeout = setTimeout(() => {
						        app.showModal=false
						      }, 1000);
				    	console.log(response);   
							
				    });							  	
			  },
	
	  		ListarEspecialidad:function(){
				    const options = {
				                method: 'POST',	
				                url: "../EspecialidadController",
								data: "action=Listar",
				            };
				     axios(options)
				    .then(function(response){
					app.RolList=response.data;
					console.log(app.RolList);   
							
				    });							  	
			  },
	
	 	 	SelectEspecialidad:function(){
			    var dataSelected =event.target.value;
			    const options = {
			                method: 'POST',
			          		url: "../EspecialidadController",
 							data: 'codigo='+dataSelected+'&action=BuscarId',
			            };
			    axios(options)
				    .then(function(response){
					app.Rol=response.data[0];
					console.log(app.Rol);   							
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
			this.ListarEspecialidad();

		    },
			created:function(){ 		    			
		    }
		  })	