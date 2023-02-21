function eliminarinsumo(id_insumo) {
	console.log(id_insumo);
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
				 url:"/insumos/"+id_insumo,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/insumos";
		    	}
		    });
		  } 
		});
}

function guardarinsumo(){
	
	alert("Se han guardado los cambios")
	
}

function crearinsumo(){
	
	alert("Se ha creado un nuevo insumo")
	
}