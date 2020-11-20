

$(document).ready(function () {
$('#SltVenta').selectpicker({
    size: 6
 });


$('#SltVenta').change(function(){
	
	  var Selected=$('#SltVenta').val();
      var Select=$('#SltVenta option:selected').val();
	//var usuario = document.getElementById('ventasform:usuario').value; 
	//$('#ventasform:usuario').val("UserTest");
	document.getElementById('ventasform:usuario').value="ejemplo"; 
	 //usuario.value = "UserTest";
	console.log("Elegio Txto "+Select);
	console.log("Valor "+Select);
 	//var juego = document.getElementById('ventasform:juego').value; 
	// juego.value = "Juego Test";
 	//var precio = document.getElementById('ventasform:precio').value; 
	// precio.value = "19999";

});
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
		console.log(resp);
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
	
//	   $("#LoginUserDiv").hide();
	//   $("#UsuarioDiv").append("<a >"+resp["usuario"]+"</a>");
			location.reload();
	  // console.log(resp+" asa" + resp["usuario"]);
		//	$("#success_tic").modal('show');		
	
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
	   console.log(resp);
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
		$('#vimagename').attr("src","../../resources/img/review/"+resp[0]["ImagenName"]);	
	   console.log(resp);
		values=resp;
    });
  }


function SendVenta(){
	//console.log(values);
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


