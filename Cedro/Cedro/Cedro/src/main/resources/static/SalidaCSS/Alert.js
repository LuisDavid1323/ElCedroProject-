function eliminarSalida(id_salida) {
	console.log(id_salida);
	swal({
		  title: "¿Está seguro de eliminar esta salida?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/salidas/"+id_salida,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Salida eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/salidas";
		    	}
		    });
		  } 
		});
}

function guardarsalida(){
	
	alert("Se han guardado los cambios")
	
}

function crearsalida(){
	
	alert("Se ha creado una nueva salida")
	
}