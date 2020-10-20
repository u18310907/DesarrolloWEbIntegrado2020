

	const app=new Vue({
		  el:'#app',
		  data:{ 
			    Categoria:{
					checked: '',
				},
				ImgUpdate:{
					liked: '',
				},
				Callfrm:'',
				Cat:[],
				Photo:[],
				//modal: '#success_tic',
		  },  methods:{				
			  AgregarCateogria:function(){
				 	var formdata=app.ToFormData(app.Categoria);
					var modal=$(this.$refs.success_tic);
				    const options = {
				                method: 'POST',	
  								data: formdata,
				                url: "../AgregarCategoria",
				            };
				     axios(options)
				    .then(function(response){
							modal.modal('show');
				    });		
									  	
			  },
	
			ActualizarCategoria:function(){
				 	var formdata=app.ToFormDataT2(app.Categoria);
					var modal=$(this.$refs.success_tic);
				    const options = {
				                method: 'POST',	
  								data: formdata,
				                url: "../ActualizarCategoriImg",
				            };
				     axios(options)
				    .then(function(response){
					console.log(response);
							modal.modal('show');
				    });		
									  	
			  },
	
	
			ActualizarFoto:function(){
				 	var formdata=app.ToFormDataT3(app.ImgUpdate);
					var modal=$(this.$refs.success_tic);
				    const options = {
				                method: 'POST',	
  								data: formdata,
				                url: "../ActualizarPhotoDes",
				            };
				     axios(options)
				    .then(function(response){
					console.log(response);
							modal.modal('show');
				    });		
									  	
			  },
			ListaAllCat:function(){
				  const options = {
				                method: 'POST',	
				                url: "../ListarCategoriaFoto",
				            };
				     axios(options)
				    .then(function(response){
					//	console.log(response); 
						app.Cat=response.data;
						  
				    });		
												  	
				},
				
			ListaAllFotos:function(){
				  const options = {
				                method: 'POST',	
				                url: "../AllPhotoList",
				            };
				     axios(options)
				    .then(function(response){
					console.log(response);
						app.Photo=response.data;
						  
				    });		
												  	
			 },
	
			 getDatabycat:function(){
				var _currentUrl = $("#catid option:selected").val(); 	
						    const options = {
						                method: 'POST',	
		  								data: 'catId='+_currentUrl,
						                url: "../ListaSelectCat",
						            };
						     axios(options)
						    .then(function(response){
							app.Categoria=response.data[0];
						    });		
											  	
			  },
	
			getDatabyPhoto:function(){
				var _currentUrl = $("#fotogd option:selected").val(); 	
						    const options = {
						                method: 'POST',	
		  								data: 'fotogd='+_currentUrl,
						                url: "../ListarSelectPhoto",
						            };
						     axios(options)
						    .then(function(response){
							console.log(response);
							app.ImgUpdate=response.data[0];
						    });		
											  	
			  },
			  CallForm:function(){ 
				
						    var _currentUrl = $("#Accionfor option:selected").val(); 					
							this.Callfrm =_currentUrl;
								  const options = {
				                method: 'POST',	
				                url: "../ListarCategoriaFoto",
				            };
							axios(options)
						    .then(function(response){
								console.log(response); 
								app.Cat=response.data;
								  
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


 				ToFormDataT2:function(obj){
			        var formdata = new FormData();
			        for(var key in obj){
			          formdata.append(key,obj[key]);
			        } 		
					var imagefile = document.querySelector('#foto2');
			          formdata.append("foto", imagefile.files[0]);	        
			        return formdata;       
			    },		

				ToFormDataT3:function(obj){
			        var formdata = new FormData();
			        for(var key in obj){
			          formdata.append(key,obj[key]);
			        } 		
					var imagefile = document.querySelector('#foto3');
			          formdata.append("foto", imagefile.files[0]);	        
			        return formdata;       
			    },	
		  				 
		    },		    
		    mounted:function(){ 
				this.ListaAllCat();
				this.ListaAllFotos();					
		    },

			created:function(){ 
		    			
		    }
		  })	