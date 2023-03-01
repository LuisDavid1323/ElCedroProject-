function eliminarEntrada(id_entrada) {
	console.log(id_entrada);
	swal({
		  title: "¿Está seguro de eliminar esta entrada?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/entradas/"+id_entrada,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Entrada eliminada!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/entradas";
		    	}
		    });
		  } 
		});
}

function guardarentrada(){
	
	alert("Se han guardado los cambios")
	
}

function crearentrada(){
	
	alert("Se ha creado una nueva entrada")
	
}