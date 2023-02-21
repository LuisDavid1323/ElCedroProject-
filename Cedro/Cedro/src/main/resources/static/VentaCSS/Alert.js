function eliminarventa(id_ventas) {
	console.log(id_ventas);
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
				 url:"/ventas/"+id_ventas,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/ventas";
		    	}
		    });
		  } 
		});
}

function guardarventa(){
	
	alert("Se han guardado los cambios")
	
}

function crearventa(){
	
	alert("Se ha creado una nueva venta")
	
}

