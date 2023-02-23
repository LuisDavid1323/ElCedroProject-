function eliminarTela(id_telas) {
	console.log(id_telas);
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
				 url:"/cloth/"+id_telas,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Tela eliminada!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/cloth";
		    	}
		    });
		  } 
		});
}

function guardarTela(){
	
	alert("Se han guardado los cambios")
	
}

function crearTela(){
	
	alert("Se ha creado una nueva tela")
	
}