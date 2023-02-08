function eliminarEstadop(Nombre_estado_produccion) {
	console.log(Nombre_estado_produccion);
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
				 url:"/estadosp/"+Nombre_estado_produccion,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/estadosp";
		    	}
		    });
		  } 
		});
}

function guardarEstadop(){
	
	alert("Se han guardado los cambios")
	
}

function crearEstadop(){
	
	alert("Se ha creado un nuevo registro")
	
}

