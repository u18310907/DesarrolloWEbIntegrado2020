	const app=new Vue({
		  el:'#app',
		  data:{ 
			    Elements:[],
				ImgFull:'',
				ImgThumb:'',
		  },  methods:{		
			  ListarCatFotosGaleria:function(){
				    const options = {
				                method: 'POST',	
				                url: "../ListarCategoriaFoto",
				            };
				     axios(options)
				    .then(function(response){
				    	console.log(response);   
						app.Elements=response.data;
				    });							  	
			  },
			  ListarFotosURL:function(){
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
			    ToFormData:function(obj){
			        var formdata = new FormData();
			        for(var key in obj){
			          formdata.append(key,obj[key]);
			        } 			        
			        return formdata;       
			    },			    				 
		    },		    
		    mounted:function(){ 
		
				  	this.ListarCatFotosGaleria();
					this.ListarFotosURL();
								    			
		
			
		    },

			created:function(){ 
		    			
		    }
		  })	