$('#SltVenta').selectpicker({
    size: 6
 });

$('.stld').selectpicker({
    size: 6,
    liveSearch: true

 });

function setRegistrarUsuario(){
	var formDataS = new FormData(document.getElementById("FormDataEnvio"))
         $.ajax( {
          	type: 'POST',
       		url: '../loginSV',
            dataType: "html",
            data: formDataS,
            cache: false,
            contentType: false,
	     	processData: false
    }).done(function(resp){
		//	$("#success_tic").modal('show');		
	//	console.log(resp);
	location.reload();
    });
 }


function setFCLogin(){
	var formDataA = new FormData(document.getElementById("FormLogin"))
         $.ajax({
          	type: 'POST',
       		url: '../loginCon',
            dataType : 'json',
            data: formDataA,
            cache: false,
            contentType: false,
	     	processData: false
    }).done(function(resp){
			location.reload();	
    });
  }

function setListaDeseos(codigo){
	         $.ajax({
          	type: 'POST',
       		url: '../ListaDeseos',
            dataType : 'json',
            data: 'codjue='+codigo,
           // cache: false,
           // contentType: false,
	      //  processData: false
    }).done(function(resp){
	 //  console.log(resp);
    });
  }

var values;
function getModalById(codigo){
$.ajax({
          	type: 'POST',
       		url: '../modalListadoVen',
            dataType : 'json',
            data: 'codjue='+codigo,
			async:false,
    }).done(function(resp){
		$('#vtitulo').val(resp[0]["titulo"]);
		$('#vdescripcion').val(resp[0]["descripcion"]);
		$('#vprecio').val(resp[0]["precio"]);
		$('#vimagename').attr("src","../../resources/img/dynamic/"+resp[0]["ImagenName"]);	
	   //console.log(resp);
		values=resp;
    });
  }


function SendVenta(){
	var formData = new FormData();
	formData.append('codjue',values[0]["codjue"]);
	formData.append('precio',values[0]["precio"]);
	formData.append('titulo',values[0]["titulo"]);
	$.ajax({
	            	type: 'POST',
       		url: '../Venta',
            dataType: "html",
            data: formData,
            cache: false,
            contentType: false,
	     	processData: false
	    }).done(function(resp){
			$('#alertsuccess').addClass("show");
			$('#alertsuccess').focus();
			$('#alertsuccess').delay(2500);
  			$('#alertsuccess').hide(1500);
	    });
}



$(document).ready(function () {

$('#SltVenta').change(function(){
var codigoS=$('#SltVenta option:selected').val();
$.ajax({
          	type: 'POST',
       		url: '../VentasAdmin',
            dataType : 'json',
            data: 'codigoSelected='+codigoS,
	//		async:false,
    }).done(function(resp){
	
	document.getElementById('ventasform:operacion').value=resp[0]["codigo"]; 
	document.getElementById('ventasform:usuario').value=resp[0]["usuario"]; 
	document.getElementById('ventasform:juego').value=resp[0]["titulo"]; 
	document.getElementById('ventasform:vprecio').value=resp[0]["precio"]; 
	document.getElementById('ventasform:correo').value=resp[0]["correo"]; 
 });

});

$('#SltPromocioID').change(function(){
var codigoS=$('#SltPromocioID option:selected').val();
$.ajax({
          	type: 'POST',
       		url: '../PromoAdmin',
            dataType : 'json',
            data: 'codigoSelected='+codigoS,
	//		async:false,
    }).done(function(resp){
	console.log(resp);
	document.getElementById('promocionform:idPromocion').value=resp[0]["codigo"]; 
	document.getElementById('promocionform:txtpromocion').value=resp[0]["descripcion"]; 
	document.getElementById('promocionform:txtmonto').value=resp[0]["descuento"]; 
	document.getElementById('promocionform:SltPromocion').value=resp[0]["codjue"]; 
	document.getElementById('promocionform:SltPromocion').text=resp[0]["titulo"]; 
	document.getElementById('promocionform:txtestado').value=resp[0]["estado"]; 
	
	//document.getElementById('ventasform:juego').value=resp[0]["titulo"]; 
	//document.getElementById('ventasform:vprecio').value=resp[0]["precio"]; 
	//document.getElementById('ventasform:correo').value=resp[0]["correo"]; 

	//	$('#vtitulo').val(resp[0]["titulo"]);
	//	$('#vdescripcion').val(resp[0]["descripcion"]);
	//	$('#vprecio').val(resp[0]["precio"]);
	//	$('#vimagename').attr("src","../../resources/img/review/"+resp[0]["ImagenName"]);	
	//  console.log(resp);
	//	values=resp;
 });
});



$('#sltJuegoBox').change(function(){
var codigoS=$('#sltJuegoBox option:selected').val();
$.ajax({
          	type: 'POST',
       		url: '../JuegosAdmin',
            dataType : 'json',
            data: 'codigoSelected='+codigoS,
	//		async:false,
    }).done(function(resp){
	console.log(resp);
	document.getElementById('juegosform:txtJidjuego').value=resp[0]["codigo"]; 
	document.getElementById('juegosform:txtJtitulo').value=resp[0]["titulo"]; 
	document.getElementById('juegosform:txtJdescripcion').value=resp[0]["descripcion"]; 
	document.getElementById('juegosform:txtJcategoria').value=resp[0]["categoria_id"]; 
	document.getElementById('juegosform:txtJcomentario').value=resp[0]["observacion"]; 
	document.getElementById('juegosform:txtJprecio').value=resp[0]["precio"]; 
	//  console.log(resp);


 });
});



});


