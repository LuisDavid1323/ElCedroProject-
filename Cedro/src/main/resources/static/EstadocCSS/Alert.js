function eliminarEstadoc(id_estado_cotizacion) {
	console.log(id_estado_cotizacion);
	swal({
		  title: "¿Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/estadosc/"+id_estado_cotizacion,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/estadosc";
		    	}
		    });
		  } 
		});
}

function guardarEstadoc(){
	
	alert("Se han guardado los cambios")
	
}

function crearEstadoc(){
	
	alert("Se ha creado un nuevo registro")
	
}