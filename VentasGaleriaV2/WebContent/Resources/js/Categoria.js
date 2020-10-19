

	const app=new Vue({
		  el:'#app',
		  data:{ 
			    Categoria:{},
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
				    	console.log(response);   
						//$(this.$refs.modal).modal('show');
						//$(this.modal).modal('show');
							modal.modal('show');
				    });		
									  	
			  },
			 /* ListarFotosURL:function(){
					    const options = {
					                method: 'POST',	
					                url: "../FotoGetUrl",
					            };
					     axios(options)
					    .then(function(response){
					    	console.log(response);
							app.ImgFull=response.data[0];   
							app.ImgThumb=response.data[1];   
					    });							  	
				  },
			*/
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
			    			
		
			
		    },

			created:function(){ 
		    			
		    }
		  })	