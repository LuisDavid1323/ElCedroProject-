function eliminarMadera(Id_maderas) {
	console.log(Id_maderas);
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
				 url:"/maderas/"+Id_maderas,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Madera eliminada!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/maderas";
		    	}
		    });
		  } 
		});
}

function guardarMadera(){
	
	alert("Se han guardado los cambios")
	
}

function crearMadera(){
	
	alert("Se ha creado un nuevo registro de madera")
	
}