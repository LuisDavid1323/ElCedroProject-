function eliminarProducto(id_producto) {
	console.log(id_producto);
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
				 url:"/productosCRUD/"+id_producto,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Producto eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/productosCRUD";
		    	}
		    });
		  } 
		});
}

function guardarProducto(){
	
	alert("Se han guardado los cambios")
	
}

function crearProducto(){
	
	alert("Se ha creado un nuevo producto")
	
}