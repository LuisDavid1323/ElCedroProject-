function eliminarCotizacion(id_cotizacion) {
	console.log(id_cotizacion);
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
				 url:"/cotizaciones/"+id_cotizacion,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/cotizaciones";
		    	}
		    });
		  } 
		});
}

function guardarCotizacion(){
	
	alert("Se han guardado los cambios")
	
}

function crearCotizacion(){
	
	alert("Se ha creado un nueva cotización")
	
}