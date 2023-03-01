function eliminarCotizacion(id_cotizacion) {
	console.log(id_cotizacion);
	swal({
		  title: "¿Está seguro de eliminar esta cotización?",
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
		    swal("Poof! Cotización eliminada!", {
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
	
	alert("Se ha creado una nueva cotización")
	
}