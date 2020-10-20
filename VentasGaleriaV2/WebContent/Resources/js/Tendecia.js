	const app=new Vue({
		  el:'#app',
		  data:{ 
			    Listado:[],
				ImgFull:'',
				ImgThumb:'',
		  },  methods:{		
			 ListadoTopGaleria:function(){
				    const options = {
				                method: 'POST',	
				                url: "../LastAdd",
				            };
				     axios(options)
				    .then(function(response){
				//	console.log(response);
						app.Listado=response.data;
				    });							  	
			  },
			 ListarFotosURL:function(){
					    const options = {
					                method: 'POST',	
					                url: "../FotoGetUrl",
					            };
					     axios(options)
					    .then(function(response){
					    //	console.log(response);
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
				  	this.ListadoTopGaleria();	
					this.ListarFotosURL();				
		    },

			created:function(){ 
		    			
		    }
		  })	