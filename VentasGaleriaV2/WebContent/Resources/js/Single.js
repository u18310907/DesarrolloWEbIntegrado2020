
	 $("#foto").fileinput({
	  //maxFileSize: 1000,
	  //'showUpload': false,
	  'showCaption': false, // The "1 file selected non-editable text field"
      'showRemove': false, // The "Remove" button
      'showUpload': false, // The "Upload" button
      'showBrowse': true, 
	  'allowedFileExtensions': ['jpg', 'png']
	  }); 
	$(document).ready(function() {	
		Title();
	    LoadingImg();
	});
		
	


	function LoadingImg(){
		$.urlParam = function(name){
		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		    if (results==null) {
		       return null;
		    }
		    return decodeURI(results[1]) || 0;
		}
		var id = $.urlParam('id');
		if(id==null)
			id=0;
		//console.log(id);
	
    	$.ajax({
               	   url : '../ListarFotosV',
	               type : 'POST',
	               data: 'id='+id,
	               dataType : 'json',
			       async: false,
	                success : function (data)
	                {		
	                	$.ajax({
	                   		url : '../FotoGetUrl',
	    	               type : 'POST',
	    	               dataType : 'json',
						   async: false,
	    	                success : function (url)
	    	                {	
	    	                	var ruta= url[0];
	    	                	console.log(ruta);
								$('#ImgSet div').remove();
	    	            	    for(var impresion in data){	    	
							    	$('#ImgSet').append('<div class="col-6 col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="100">'
							    	          +'<a href="'+ruta+ data[impresion]["urlFull"]+'" class="d-block photo-item" data-fancybox="gallery">'
							    	          +' <img src="'+ruta+ data[impresion]["urlFull"]+'" alt="Image" class="img-fluid">'
							    	          +'<div class="photo-text-more">'
							    	          +'<span class="icon icon-search"></span>'
							    	          +'</div>'
							    	          +'</a>'
							    	          +'</div>');
								
							    }
	    	                }
	                		});
	                	
							
						
	                }

	});
	}
	
function SendImg(){
	    $.urlParam = function(name){
		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		    if (results==null) {
		       return null;
		    }
		    return decodeURI(results[1]) || 0;
		}
		var id = $.urlParam('id');
		if(id==null)
			id=0;
			
	var formData = new FormData(document.getElementById("FormData"));
	formData.append('catid',id);
         $.ajax( {
          	type: 'POST',
       		url: '../RegistrarFoto',
            dataType: "html",
            data: formData,
            cache: false,
            contentType: false,
	     	processData: false
    }).done(function(resp){
				 // LoadingImg();
                //  alert(resp);
			$("#success_tic").modal('show');		
    });
    }


function Title(){
	    $.urlParam = function(name){
		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		    if (results==null) {
		       return null;
		    }
		    return decodeURI(results[1]) || 0;
		}
		var id = $.urlParam('id');
		if(id==null)
			id=0;
         $.ajax( {
          	   url : '../TitleCategoria',
	           type : 'POST',
	           data: 'id='+id,
	           dataType : 'json',
    }).done(function(resp){
			//	console.log(resp[0]["descripcion"]);
				//$('#Title h2').remove();
				$('#Title h2').append('<h2 class="text-white mb-4" >'+resp[0]["descripcion"]+'</h2>');
    });
    }