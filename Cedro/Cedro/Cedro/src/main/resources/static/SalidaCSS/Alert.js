function eliminarSalida(id_salida) {
	console.log(id_salida);
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
				 url:"/salidas/"+id_salida,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
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
	
	alert("Se ha creado un nueva salida")
	
}